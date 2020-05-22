public void extractImages(Document document) {
        ImageExtractor_HTML_Data.getInstance().documentId = document.getId();

        Thread javaFxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    ImageExtractor_HTML_Browser browser = new ImageExtractor_HTML_Browser();

                    @Override
                    public void run() {
                        browser.start(new Stage());
                    }
                });
            }
        });
        javaFxThread.setDaemon(true);
        javaFxThread.start();

        synchronized (ImageExtractor_HTML_Data.getInstance()) {
            try {
                ImageExtractor_HTML_Data.getInstance().wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }