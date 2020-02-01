package Anton.Password;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PasswordTest {

    @Test
    public void generatePassword() {

        List<Character> list = new ArrayList<>(Arrays.asList('2', 'T'));
        Password pS = new Password();
        int lengthPass = 8;
        String password = pS.generatePassword(list, lengthPass);
        boolean check = true;
        System.out.println(password);
        if (password.equals("22") || password.equals("TT"))
            check = false;
        assertTrue(check);
    }

    @Test
    public void generatePassword2() {

        List<Character> list = new ArrayList<>(Arrays.asList('3', 'E', 'x'));
        Password pS = new Password();
        int lengthPass = 15;
        String password = pS.generatePassword(list, lengthPass);
        boolean check = true;
        boolean first = password.contains("33");
        boolean second = password.contains("EE");
        boolean third = password.contains("xx");
        if (first || second || third)
            check = false;
        System.out.println(password);
        assertTrue(check);
    }
}