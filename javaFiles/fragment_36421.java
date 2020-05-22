url="http://a1408.g.akamai.net/5/1408/1388/2005110405/1a1a1ad948be278cff2d96046ad90768d848b41947aa1986/sample_mpeg4.mp4";
        BrowserFieldConfig browserFieldConfig = new BrowserFieldConfig();
        browserFieldConfig.setProperty(BrowserFieldConfig.NAVIGATION_MODE, BrowserFieldConfig.NAVIGATION_MODE_POINTER);
        browserFieldConfig.setProperty(BrowserFieldConfig.JAVASCRIPT_ENABLED,Boolean.TRUE);
        browserFieldConfig.setProperty(BrowserFieldConfig.ALLOW_CS_XHR,Boolean.TRUE);
        browserField=new BrowserField(browserFieldConfig);
        browserField.requestContent(url);
        add(browserField);