package org.kata;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LettersDiamondTest {

    @Test
    public void testCanPrintDiamondForLetterA() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        String result = lettersDiamond.generateAlphabetDiamond('A');
        String diamond_A =  "A";
        assertEquals(diamond_A, result );
    }

    @Test
    public void testCanPrintDiamondForLetterB() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        String result = lettersDiamond.generateAlphabetDiamond('B');
        String diamond_B =  " A \nB B\n A ";
        assertEquals(diamond_B, result);
    }

    @Test
    public void testGenerateDiamondForLetterC() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        String result = lettersDiamond.generateAlphabetDiamond('C');
        String diamond_C = String.format("  A  \n B B \nC   C\n B B \n  A  ");
        assertEquals(diamond_C, result );
    }

    @Test
    public void testCanGenerateDiamondForLetterD() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        String result = lettersDiamond.generateAlphabetDiamond('D');
        String diamond_D = "   A   \n  B B  \n C   C \nD     D\n C   C \n  B B  \n   A   ";
        assertEquals(diamond_D, result);
    }

    @Test
    public void testShouldThrowExceptionForLowerCaseLetter() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lettersDiamond.generateAlphabetDiamond('a');
        });

        String expectedMessage = "Input should be uppercase letter";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testShouldThrowExceptionForInvalidCharacter() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lettersDiamond.generateAlphabetDiamond('@');
        });

        String expectedMessage = "Input should be uppercase letter";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testShouldValidateArgument() {
        LettersDiamond lettersDiamond = new LettersDiamond();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lettersDiamond.validateArgument("AB");
        });

        String expectedMessage = "Argument should be a character";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
