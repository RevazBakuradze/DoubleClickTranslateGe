package com.practice.translatege.api.model;

public class TranslationOutput {

    private String translation;

    public TranslationOutput() {
    }

    public TranslationOutput(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "TranslationOutput{" +
                "translation='" + translation + '\'' +
                '}';
    }
}
