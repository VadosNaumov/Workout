package Anton;

import java.util.Arrays;
import java.util.Scanner;

public class Extractor {

    public static void main(String[] args) {

        Extractor extractor = new Extractor();
        String line;
        String[] mas;

        try {
            line = extractor.enterNumbers();              // считываем строку

            mas = line.split("\\s+");  // преобразуем строку в массив строк, разделенных пробелом(неограниченное количество)

            int[] numbers = new int[mas.length]; // наши числа
            for (int i = 0; i < mas.length; i++) {
                numbers[i] = Integer.parseInt(mas[i]);
            }

            System.out.println(Arrays.toString(numbers));
        } catch (Exception e) {
            System.out.println("Ошибка!");
            e.printStackTrace();
        }
    }

    private String enterNumbers() {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            System.out.println("Введите два числа от 1 до 3 включительно, через пробел");
            // требуемый ввод: пробелы(от нуля до бесконечности), число, пробелы(от нуля до бесконечности), число, пробелы(от нуля до бесконечности)
            line = scanner.nextLine().trim();   // считываем введенную строку и убираем пробелы в начале и в конце строки

            // вернет true если в введенной строке будут только пробелы и/или цифры 1, 2, 3
            if (line.matches("[1-3]\\s+[1-3]")) {
                System.out.println("правильно");
                break;
            } else {
                System.out.println("Введенные данные не соответствуют условию.");
            }
        }
        return line;
    }
}
