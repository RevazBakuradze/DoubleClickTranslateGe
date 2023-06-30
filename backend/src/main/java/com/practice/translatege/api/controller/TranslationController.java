package com.practice.translatege.api.controller;

import com.practice.translatege.api.model.TranslationOutput;
import com.practice.translatege.service.TranslationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslationController {

    @GetMapping("/")
    public TranslationOutput translation(@RequestParam String englishWord) {

        //TODO: rename variables
        TranslationService translation = new TranslationService();
        translation.setInput(englishWord);

        String output = translation.parseOutput();

        TranslationOutput translationOutput = new TranslationOutput();
        translationOutput.setTranslation(output);

        return translationOutput;
    }

    //TODO: support Geo -> Eng
    //TODO: cut sims
}
