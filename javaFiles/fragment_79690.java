// Set HostService inherit from Application class 
    ServiceUtil.hostServices = getHostServices();

    // HTML code
    final String htmlCode = "<a href='http://stackoverflow.com ' target='_blank'>Open a Web URL</a>" +
                            "<a href=\"file:///C:\\Users\\Dev\\debug.log\">Open a Local File</a> ";

    // Create a WebView 
    final WebView webView = new WebView();        

    webView.getEngine().loadContent(htmlCode);

    webView.getEngine().locationProperty().addListener(new ChangeListener<String>() {
         @Override
         public void changed(ObservableValue<? extends String> observable, final String oldValue, final String newValue) {

                      if((newValue != null) && (!newValue.trim().equals(""))) {

                          Platform.runLater(new Runnable() {

                              @Override
                              public void run() {

                                  // Reset content as HTML codes
                                  // NB: This will make stop opening URL in WebView
                                  webView.getEngine().loadContent(htmlCode);

                                  // Direct URL to local browser
                                  ServiceUtil.hostServices.showDocument(newValue);
                              }
                          });
                      }
                  }
     });