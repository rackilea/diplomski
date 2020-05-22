package com.stackoverflow;
public class ActionClass extends Action {
    public Map act(Redirector redirector, SourceResolver resolver, Map objectModel, String source, Parameters params) {
        Map<String, String> sitemapParams = new HashMap<String, String>();
        sitemapParams.put("myVariable", "hello world!");
        return sitemapParams;
    }
}