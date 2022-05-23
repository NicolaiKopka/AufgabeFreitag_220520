import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationMethodsTest {
    @Test
    void shouldReturnResultArrayOnlyTrueIfAllConditionsMet() {
        String[] pwArray = {"passwortmitUPper1$", "passwortmitUPper2$", "langesPasswort23467<"};
        boolean[] trueArray = {true, true, true, true, true};
        boolean[][] expected = new boolean[3][];
        expected[0] = trueArray;
        expected[1] = trueArray;
        expected[2] = trueArray;
        boolean[][] actual = ValidationMethods.checkPwList(pwArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyResultArrayIfNothingIsEntered() {
        String[] pwArray = new String[0];
        boolean[][] expected = new boolean[0][];
        boolean[][] actual = ValidationMethods.checkPwList(pwArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseIfAlphaNumericFails() {
        String testPassword = "langesPWohneSonderze1chen";
        boolean[] expected = {true, true, true, false, true};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseIfLengthFails() {
        String testPassword = "kUrz1#";
        boolean[] expected = {false, true, true, true, true};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseIfNumberFails() {
        String testPassword = "langesPasswortOhneZahl&*";
        boolean[] expected = {true, true, true, true, false};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseIfUpperCaseFails() {
        String testPassword = "langespasswortm1t#";
        boolean[] expected = {true, true, false, true, true};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueIfAllChecksValidated() {
        String testPassword = "langesPWm1tSonderzeichen@<";
        boolean[] expected = {true, true, true, true, true};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnBooleanArrayWithRespectiveTestValues() {
        String testPassword = "kurz";
        boolean[] expected = {false, true, false, false, false};
        boolean[] actual = ValidationMethods.checkAllCases(testPassword);
        assertArrayEquals(expected, actual);
    }
}