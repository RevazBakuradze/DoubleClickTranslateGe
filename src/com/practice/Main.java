package com.practice;

public class Main {
    public static void main(String[] args) {

        translate("codadassdase");

    }

    private static void translate(String englishWord) {
        TranslationOutput color = new TranslationOutput(englishWord);
        System.out.println(color.parseOutput());
    }
}
