timer = new Timer();
        timer.scheduleAtFixedRate(new WebViewProcess(), 3000, 1000);

private class WebViewProcess extends TimerTask {

        @Override
        public void run() {
            Platform.runLater(() -> {
                    webEngine.executeScript("someFunction();");
            });
        }
    }