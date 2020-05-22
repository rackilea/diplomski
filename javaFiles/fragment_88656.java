SubstanceLookAndFeel.setFontPolicy(new FontPolicy() {
    public FontSet getFontSet(String arg0, UIDefaults arg1) {
        FontSet fontSet = new FontSet() {
            public FontUIResource getWindowTitleFont() {
                return new FontUIResource(new Font("Serif", Font.PLAIN, 12)); //this is where the title font changes
            }

            public FontUIResource getTitleFont() {
                return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
            }

            public FontUIResource getSmallFont() {
                return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
            }

            public FontUIResource getMessageFont() {
                return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
            }

            public FontUIResource getMenuFont() {
                return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
            }

            public FontUIResource getControlFont() {
                return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
            }
        };
        return fontSet;
    }
});