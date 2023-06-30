package com.practice.translatege.service;

import java.io.IOException;

public class TranslationAccess {

    /**
     * Access method uses API call to translate.ge
     * */
    public static String askTranslateGe(String english) {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

        StringBuffer url = new StringBuffer("https://translate.ge/api/search/eng/");
        url.append(english);

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url.toString())
                .method("GET", null)
                .addHeader("Content-Type", "text/plain")
                .build();
        okhttp3.Response response = null;

        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Cannot send request");
            e.printStackTrace();
        }

        String georgian = null;
        try {
            georgian = response.body().string();
        } catch (IOException e) {
            System.out.println("Cannot get response");
            e.printStackTrace();
        }

        System.out.println("askTranslateGe: sending request for " + english);
        //TODO: use log
        return georgian;
    }
}
