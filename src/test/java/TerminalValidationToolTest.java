import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalValidationToolTest {

    @Test
    void shouldReturnStringArrayWithMessagesIfAllRequirementsMet() {
        String testPassword = "langesPasswort1234#";
        String message = "All good!";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessageIfLengthFails() {
        String testPassword = "kUrz1#";
        String message = "Password too short. min 8 characters required";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessageIfNumberFails() {
        String testPassword = "langesPwkeineZahl@";
        String message = "Password does not contain numbers. At least one required";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessageIfAlphaNumericFails() {
        String testPassword = "langesPwM1tZahl";
        String message = "Password does not contain NonAlphaNumeric Characters. At least one required";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessageIfUpperCaseFails() {
        String testPassword = "langespwm1t#";
        String message = "Password does not contain upper case letters. At least one required";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessageIfLowerCaseFails() {
        String testPassword = "LANGESPW45%";
        String message = "Password does not contain lower case letters. At least one required";
        String[] expected = {message};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnStringArrayWithMessagesIfMultipleFails() {
        String testPassword = "kurz";
        String messageLength = "Password too short. min 8 characters required";
        String messageNumber = "Password does not contain numbers. At least one required";
        String messageUpperCase = "Password does not contain upper case letters. At least one required";
        String messageAlphaNumeric = "Password does not contain NonAlphaNumeric Characters. At least one required";
        String[] expected = {messageLength, messageUpperCase, messageAlphaNumeric, messageNumber};
        boolean[] results = ValidationMethods.checkAllCases(testPassword);
        String[] actual = TerminalValidationTool.generateMessages(results);
        assertArrayEquals(expected, actual);
    }

    //ready for review
}