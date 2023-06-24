package com.practice;

public class Translation {

    private String word;
    private String desc;
    private String dict_type;
    private String dict_name;
    private String id;

    public Translation() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "word='" + word + '\'' +
                ", desc='" + desc + '\'' +
                ", dict_type='" + dict_type + '\'' +
                ", dict_name='" + dict_name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
