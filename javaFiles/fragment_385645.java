UI.getCurrent().setErrorHandler(new ErrorHandler() {

        @Override
        public void error(com.vaadin.server.ErrorEvent event) {
            Page.getCurrent().setLocation("error");
            // Do the default error handling (optional)
            DefaultErrorHandler.doDefault(event);
        }

    });