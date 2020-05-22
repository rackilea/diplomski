private native HeadElement getHeadElement() /*-{
    return $doc.getElementsByTagName("head")[0];
}-*/;

/**
* Inject the GWT theme style sheet based on the RTL direction of the current
* locale.
*/
private void injectThemeStyleSheet() {
    //you could inherit any style in your gwt.xml and change the whole theme by changing the THEME string
    //String THEME = "chrome" or "dark" or "standard"
    String THEME = "clean";
    // Choose the name style sheet based on the locale.
    String styleSheet = "gwt/" + THEME + "/" + THEME;
    styleSheet += LocaleInfo.getCurrentLocale().isRTL() ? "_rtl.css" : ".css";
    // Load the GWT theme style sheet
    String modulePath = GWT.getModuleBaseURL();
    LinkElement linkElem = Document.get().createLinkElement();
    linkElem.setRel("stylesheet");
    linkElem.setType("text/css");
    linkElem.setHref(modulePath + styleSheet);
    getHeadElement().appendChild(linkElem);
}