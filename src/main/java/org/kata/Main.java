package org.kata;

public class Main {
    public static void main(String[] args) {
        LettersDiamond diamond = new LettersDiamond();
        System.out.println(diamond.generateAlphabetDiamond(diamond.validateArgument(args[0])));
    }
}
