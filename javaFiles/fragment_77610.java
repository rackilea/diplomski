public void onPageFinished(WebView webview, String Url) {
        final WebView newView = webview;

        if (ScrollX > 0) { // <-- int variable containing users Scroll position
            newView.postDelayed(new Runnable() {
                public void run() {
                    if (newView.getProgress() == 100) {
                        newView.postDelayed(new Runnable() {
                            public void run() {
                            newView.scrollTo(ScrollX, ScrollY);
                            pageloaded = true; 
                            }
                        }, 10);
                    } else {
                        newView.post(this);
                    }
                }
            }, 10);
        }
    }