if (roles.contains("role1")) {
    GWT.runAsync(new RunAsyncCallback() {
        public void onFailure(Throwable caught) {
            Window.alert("Code download failed");
        }

        public void onSuccess() {
            // code here if the user has role1
        }
    });
}
if (roles.contains("role2")) {
    GWT.runAsync(new RunAsyncCallback() {
        public void onFailure(Throwable caught) {
            Window.alert("Code download failed");
        }

        public void onSuccess() {
            // code here if the user has role2
        }
    });
}
// and so on