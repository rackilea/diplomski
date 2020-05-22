engine.getLoadWorker().stateProperty().addListener(
        new ChangeListener<State>() {
            public void changed(ObservableValue ov, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
                    //engine.executeScript("addPoint(0,-26.487000,151.984000)");
                    JSObject win = (JSObject) engine.executeScript("window");
                    win.setMember("javaObj", new Bridge(engine));
                    engine.executeScript("javaObj.start()");                                    }
            }
        });
engine.load(url.toString());