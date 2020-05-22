package com.ui4j.sample;

import com.ui4j.api.browser.BrowserEngine;
import com.ui4j.api.browser.BrowserFactory;
import com.ui4j.api.browser.Page;
import com.ui4j.api.dom.Document;
import com.ui4j.api.dom.Element;

public class Main {

    public static void main(String[] args) {
        BrowserEngine engine = BrowserFactory.getWebKit();
        Page page = engine.navigate("http://anaptyxi.gov.gr/ergopopup.aspx?mis=277649");

        page.show();

        Document document = page.getDocument();

        // click to second tab
        document.queryAll(".rtsLI").get(1).click();

        // extract content from the first tab
        Element firstTab = document.query("#dnn_ctr521_View_pageEpiskopisi").get();
        String value = firstTab.query(".stoixeiaValues").get().getText().get();
        System.out.println(value); // prints 22.146.837 €

        // #dnn_ctr521_View_pageIpoerga second tab
        // #dnn_ctr521_View_pagePoreia third tab
        // #dnn_ctr521_View_pageForeis fourth tab
        // #dnn_ctr521_View_pageEggrafa fifth tab
    }
}