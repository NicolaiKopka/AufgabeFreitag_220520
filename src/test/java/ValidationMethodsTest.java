import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationMethodsTest {

    @Test
    void shouldReturnFalseIfPwLengthIsLessThan8() {
        String testPassword = "kleinpw";
        boolean actual = ValidationMethods.checkPasswordLength(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueIfPwLengthIsEqual8() {
        String testPassword = "kleinpw8";
        boolean actual = ValidationMethods.checkPasswordLength(testPassword);
        assertTrue(actual);
    }

    @Test
    void shouldReturnTrueIfPwLengthIsGreater8() {
        String testPassword = "langespwmitvielenzeichen";
        boolean actual = ValidationMethods.checkPasswordLength(testPassword);
        assertTrue(actual);
    }

    @Test
    void shouldReturnTrueIfPwContainsNumbers() {
        String testPassword = "passwortmitzahlen1234";
        boolean actual = ValidationMethods.checkForNumbers(testPassword);
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfPwContainsNoNumbers() {
        String testPassword = "passwortohnezahlen";
        boolean actual = ValidationMethods.checkForNumbers(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseIfPwContainsNoUpperCaseLetters() {
        String testPassword = "passwortohneupper";
        boolean actual = ValidationMethods.checkForUpperCaseLetters(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueIfPwContainsUpperCaseLetters() {
        String testPassword = "passwortmitUPper";
        boolean actual = ValidationMethods.checkForUpperCaseLetters(testPassword);
        assertTrue(actual);
    }

    @Test
    void shouldReturnTrueIfPwContainsNonAlphaNumerics() {
        String testPassword = "Pper@&";
        boolean actual = ValidationMethods.checkForAlphaNumeric(testPassword);
        assertTrue(actual);
    }

    @Test
    void shouldReturnFalseIfPwContainsNoNonAlphaNumerics() {
        String testPassword = "kleinesPasswort12";
        boolean actual = ValidationMethods.checkForAlphaNumeric(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnResultArrayOnlyTrueIfAllConditionsMet() {
        String[] pwArray = {"passwortmitUPper1$", "passwortmitUPper2$", "langesPasswort23467<"};
        boolean[] expected = {true, true, true};
        boolean[] actual = ValidationMethods.checkPwList(pwArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyResultArrayIfNothingIsEntered() {
        String[] pwArray = new String[0];
        boolean[] expected = new boolean[0];
        boolean[] actual = ValidationMethods.checkPwList(pwArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseIfAlphaNumericFails() {
        String testPassword = "langesPWohneSonderze1chen";
        boolean actual = ValidationMethods.checkAllCases(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseIfLengthFails() {
        String testPassword = "kUrz1#";
        boolean actual = ValidationMethods.checkAllCases(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseIfNumberFails() {
        String testPassword = "langesPasswortOhneZahl&*";
        boolean actual = ValidationMethods.checkAllCases(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnFalseIfUpperCaseFails() {
        String testPassword = "langespasswortm1t#";
        boolean actual = ValidationMethods.checkAllCases(testPassword);
        assertFalse(actual);
    }

    @Test
    void shouldReturnTrueIfAllChecksValidated() {
        String testPassword = "langesPWm1tSonderzeichen@<";
        boolean actual = ValidationMethods.checkAllCases(testPassword);
        assertTrue(actual);
    }

}