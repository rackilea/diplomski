/**
     * Set the set of styles to be used to render the various
     * HTML elements.  These styles are specified in terms of
     * CSS specifications.  Each document produced by the kit
     * will have a copy of the sheet which it can add the
     * document specific styles to.  By default, the StyleSheet
     * specified is shared by all HTMLEditorKit instances.
     * This should be reimplemented to provide a finer granularity
     * if desired.
     */
    public void setStyleSheet(StyleSheet s) {
        if (s == null) {
            AppContext.getAppContext().remove(DEFAULT_STYLES_KEY);
        } else {
            AppContext.getAppContext().put(DEFAULT_STYLES_KEY, s);
        }
    }

    /**
     * Get the set of styles currently being used to render the
     * HTML elements.  By default the resource specified by
     * DEFAULT_CSS gets loaded, and is shared by all HTMLEditorKit
     * instances.
     */
    public StyleSheet getStyleSheet() {
        AppContext appContext = AppContext.getAppContext();
        StyleSheet defaultStyles = (StyleSheet) appContext.get(DEFAULT_STYLES_KEY);

        if (defaultStyles == null) {
            defaultStyles = new StyleSheet();
            appContext.put(DEFAULT_STYLES_KEY, defaultStyles);
            try {
                InputStream is = HTMLEditorKit.getResourceAsStream(DEFAULT_CSS);
                Reader r = new BufferedReader(
                        new InputStreamReader(is, "ISO-8859-1"));
                defaultStyles.loadRules(r, null);
                r.close();
            } catch (Throwable e) {
                // on error we simply have no styles... the html
                // will look mighty wrong but still function.
            }
        }
        return defaultStyles;
    }