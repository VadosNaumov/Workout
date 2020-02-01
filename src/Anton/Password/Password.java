package Anton.Password;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
The password is hard to crack if it contains at least
A uppercase letters, at least B lowercase letters,
at least C digits and includes exactly N symbols.
Also, a password cannot contain two or more same characters
coming one after another. For a given numbers A, B, C, N
you should output password that matches these requirements.
Sample input:
3 4 1 8
Sample output:
PaSsw0rD
 */
public class Password {

    public static void main(String[] args) {
        String[] enter = new String[4];
        String result;
        int i = 0;

        while (true){
            try {
                enter = new Password().enterLine();
                break;
            } catch (InvalidInputException e) {
                e.printStackTrace();
                System.out.println("Введенные данные не соответствуют условию.");
            } finally {
                if (i++ >= 3)
                    break;
            }
        }

        int temp;
        temp = Integer.parseInt(enter[0]);
        int bigLetters = Math.min(temp, 26);
        temp = Integer.parseInt(enter[1]);
        int smallLetters = Math.min(temp, 26);
        temp = Integer.parseInt(enter[2]);
        int digits = Math.min(temp, 10);
        int lengthPassword = Integer.parseInt(enter[3]);

        List<Character> setForPass;
        setForPass = new Password().getSetForPassword(bigLetters, smallLetters, digits);

        result = new Password().generatePassword(setForPass, lengthPassword);

        System.out.println(setForPass);
        System.out.println("Password = " + result);
    }

    public String generatePassword(List<Character> setPass, int lengthPass) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lengthPass; i++) {
            Character ch = setPass.get(new Random().nextInt(setPass.size()));
            if (sb.length() > 0 && !ch.equals(sb.charAt(sb.length() - 1))) {
                sb.append(ch);
            } else if (sb.length() == 0) {
                sb.append(ch);
            } else i--;
        }

        return sb.toString();
    }

    private List<Character> getSetForPassword(int bL, int sL, int dg) {
        List<Character> setUpperLet = new Password().generateSet(bL, 'A');
        List<Character> setLowerLet = new Password().generateSet(sL, 'a');
        List<Character> setDigit = new Password().generateSet(dg, '0');

        List<Character> setForPass = new ArrayList<>();
        setForPass.addAll(setUpperLet);
        setForPass.addAll(setLowerLet);
        setForPass.addAll(setDigit);

        return setForPass;
    }

    private List<Character> generateSet(int numberSign, Character ch) {
        List<Character> setSi = new ArrayList<>();
        Random random = new Random();
        int bound = 26;
        if (Character.isDigit(ch)){
            bound = 10;
        }
        for (int i = 0; i < numberSign; i++) {
            Character symbol = (char) (random.nextInt(bound) + (int)ch);
            if (setSi.contains(symbol)){
                i--;
                continue;
            }
            setSi.add(symbol);
        }
        return setSi;
    }

    private String[] enterLine() throws InvalidInputException {
        System.out.println("Введите четыре числа через пробел:\n" +
                "1е - количество букв в верхнем регистре\n" +
                "2е - количество букв в нижнем регистре\n" +
                "3е - количество цифр\n" +
                "4е - длина пароля");
        String[] enter;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        enter = line.trim().split("\\s+");
        if (enter.length != 4 || !line.matches("[\\d\\s]+"))
            throw new InvalidInputException();
        return enter;
    }
}
