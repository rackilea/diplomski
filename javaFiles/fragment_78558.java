webView.getEngine().getLoadWorker().stateProperty().addListener(
            new ChangeListener<Worker.State>() {
                public void changed(ObservableValue ov, 
                      Worker.State oldState, Worker.State newState) {
            System.out.println(webView.getEngine().getLoadWorker().exceptionProperty());
             ...