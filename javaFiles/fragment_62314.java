browser.setPopupHandler(new PopupHandler() {
        @Override
        public PopupContainer handlePopup(PopupParams popupParams) {
            browser.loadURL(popupParams.getURL());

            return null;
        }
    });