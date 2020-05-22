public void onClick(ClickEvent event) {
    GWT.runAsync(new RunAsyncCallback() {
      public void onFailure(Throwable caught) {
        Window.alert("Code download failed");
      }

      public void onSuccess() {
        Window.alert("Hello, AJAX");
      }
    });
  }
});