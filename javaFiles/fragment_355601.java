somethingService.isA(new AsyncCallback<Boolean>() {
        @Override
        public void onSuccessImpl(final Boolean response) {
            //will be executed on success of THIS call
        }
        @Override
        public void onFailure(final Throwable caught) {
            // not relevant here
        }
});

somethingService.isB(new AsyncCallback<Boolean>() {
        @Override
        public void onSuccessImpl(final Boolean response) {
            //will be executed on success of THIS call
        }
        @Override
        public void onFailure(final Throwable caught) {
            // not relevant here
        }
});