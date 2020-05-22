f.addFocusListener(new FocusListener() {
        @Override
        public void focus(FocusEvent event) {
            b.setClickShortcut(KeyCode.ENTER);
        }
    });
    f.addBlurListener(new BlurListener() {
        @Override
        public void blur(BlurEvent event) {
            b.removeClickShortcut();
        }
    });