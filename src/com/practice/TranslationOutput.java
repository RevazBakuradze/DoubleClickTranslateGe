package com.practice;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.practice.TranslationAccess.askTranslateGe;

public class TranslationOutput {
    private final static int DEFAULT_SUGGESTIONS = 3;
    private String input;
    private List<String> english;
    private List<String> georgian;

    public TranslationOutput(String englishWord) {
        this.input = englishWord;

        Translation[] translations = output();
        english = Arrays.stream(translations).map(Translation::getWord).toList();
        georgian = Arrays.stream(translations).map(Translation::getDesc).toList();
    }

    public String parseOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(DEFAULT_SUGGESTIONS, english.size()); i++) {
            stringBuilder.append(removeLineBreaks(english.get(i)));
            stringBuilder.append(" -> ");
            stringBuilder.append(removeLineBreaks(georgian.get(i)));
            stringBuilder.append("\n\n");
        }

        String translationOutput = stringBuilder.toString();
        if (StringUtils.isEmpty(translationOutput)) {
            return "ვერ ვთარგმნი, არ ვიცი :/";
        }

        return translationOutput;
    }

    private Translation[] output() {
        String translateGeOutput = askTranslateGe(input);
        Map<String, JsonElement> translateGeOutputAsMap = JsonParser
                .parseString(translateGeOutput)
                .getAsJsonObject()
                .asMap();
        JsonElement hitsJsonElement = translateGeOutputAsMap.get("hits");

        Gson gson = new Gson();
        Translation[] translationObjects = gson.fromJson(hitsJsonElement, Translation[].class);

        return translationObjects;
    }

    private static String removeLineBreaks(String input) {
        return StringUtils.normalizeSpace(input);
    }
}
