package edu.touro.mco264;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class IsPalindrome {
    public boolean isPalindrome(String word) {
        int full = word.length();
        int half = full/2;
        for(int i = 0; i <= half; i++) {
            if(word.charAt(i) != word.charAt(full - i - 1))
                return false;
        }
        return true;
    }

    @Test
    void isPalindrome() {
        String testString = "racecar";
        assertTrue(isPalindrome(testString));
    }

    public ArrayList<String> allPalindromes(String word) {
        ArrayList<String> palindromes = new ArrayList<String>();
        int max = word.length() - 1;

        for(int i = 0; i < max; i++) {
            char current = word.charAt(i);
            int nextIndex = word.indexOf(current, i + 1);
            while(nextIndex != -1) {
                String substring = word.substring(i, nextIndex + 1);
                if(isPalindrome(substring))
                    palindromes.add(substring);
                nextIndex = word.indexOf(current, nextIndex + 1);
            }
        }

        return palindromes;
    }

    @Test
    void allPalindromes() {
        String testString = "ABBABBACEC";
        ArrayList<String> tester = new ArrayList<String>();

        tester.add("ABBA");
        tester.add("ABBABBA");
        tester.add("BB");
        tester.add("BBABB");
        tester.add("BAB");
        tester.add("ABBA");
        tester.add("BB");
        tester.add("CEC");

        assertEquals(tester, allPalindromes(testString));
    }
}
