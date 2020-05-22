webBrowser.addWebBrowserListener(new WebBrowserAdapter() {

    @Override
    public void windowWillOpen(WebBrowserWindowWillOpenEvent e) {

        e.getNewWebBrowser().addWebBrowserListener(new WebBrowserAdapter() {
                    @Override
                    public void locationChanging(WebBrowserNavigationEvent e) {
                        final JWebBrowser webBrowser = e.getWebBrowser();
                        webBrowser.removeWebBrowserListener(this);
                        webBrowser.setMenuBarVisible(false);
                        webBrowser.setBarsVisible(false);
                        webBrowser.setFocusable(false);

                    }
                });
        }
    }