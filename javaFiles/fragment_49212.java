if (JS.isIE()) {
        imgButton = new ImgButton() {
            @Override
            public String getInnerHTML() {
                return super.getInnerHTML().replaceFirst("alt=\'[^\n]*?\'", "");
            }
        };
    } else {
        imgButton = new ImgButton();
    }