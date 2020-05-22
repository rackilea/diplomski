package com.jesperancinha.string;

public class StringReplaceBr {

    public static  String closeBrTags(String a){
        return a.replaceAll("<br(\\/)?([a-zA-z0-9='-:; \"]*)>", "<br$2 />");
    }
}