package org.kata;


import java.util.function.BiFunction;


public class LettersDiamond {

    private static final Integer OFFSET = 65;
    private static final char SPACE_CHAR = ' ';
    private static final char LETTER_A = 'A';
    private static final char NEWLINE_CHAR = '\n';

    private BiFunction<Integer,Integer, String> outsideSpacesForCurrentRow = (numRows, currentRow)->
            String.valueOf(SPACE_CHAR).repeat(Math.max(0, numRows-currentRow));

    public String generateAlphabetDiamond(char c) {
        if (Integer.valueOf(c) < Integer.valueOf('A') || Integer.valueOf(c) > Integer.valueOf('Z') ) {
            throw new IllegalArgumentException("Input should be uppercase letter");
        }
        if (c == LETTER_A) {
            return String.valueOf(LETTER_A);
        }

        int numRows = Integer.valueOf(c) - OFFSET ;

        StringBuilder sb = new StringBuilder();
        appendRowForLetterA(sb, numRows);
        sb.append(NEWLINE_CHAR);

        int numSpacesBetweenLetters = -1;
        for (int currentRow = 1; currentRow <= numRows; currentRow++) {
            numSpacesBetweenLetters = numSpacesBetweenLetters + 2;
            appendInnerDiamondRow(sb, numRows, currentRow, numSpacesBetweenLetters);
        }
        for (int currentRow = numRows - 1; currentRow >= 1; currentRow--) {
            numSpacesBetweenLetters = numSpacesBetweenLetters - 2;
            appendInnerDiamondRow(sb, numRows, currentRow, numSpacesBetweenLetters);
        }
        appendRowForLetterA(sb, numRows);
        return sb.toString();
    }

    private void appendInnerDiamondRow(StringBuilder sb, int numRows, int currentRow, int numSpacesBetweenLetters) {
        String outsideSpaces = outsideSpacesForCurrentRow.apply(numRows, currentRow);
        sb.append(outsideSpaces)
                .append((char) (OFFSET + currentRow))
                .append(String.valueOf(SPACE_CHAR).repeat(Math.max(0, numSpacesBetweenLetters)))
                .append((char) (OFFSET + currentRow))
                .append(outsideSpaces)
                .append(NEWLINE_CHAR);
    }

    private void appendRowForLetterA(StringBuilder sb, int numRows) {
        sb.append(String.valueOf(SPACE_CHAR).repeat(Math.max(0, numRows)))
                .append(LETTER_A)
                .append(String.valueOf(SPACE_CHAR).repeat(Math.max(0, numRows)));
    }

    public Character validateArgument(String arg) {
        if (arg.length() != 1) {
            throw new IllegalArgumentException("Argument should be a character");
        }
        return arg.charAt(0);
    }
}