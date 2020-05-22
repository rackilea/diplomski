@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (event.getAction() == KeyEvent.ACTION_DOWN) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                String url = new String("http://www.YourDomainName.com/PageAfterSuccessfulLogin");
                String webUrl = new String(webView.getUrl());

                if (url.equals(webUrl)) {
                    Toast.makeText(this, "You are logged in",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (webView.canGoBack()) {
                        Toast.makeText(this, "Back",
                                Toast.LENGTH_SHORT).show();
                        webView.goBack();
                    }
                }
                return true;
        }
    }
    return super.onKeyDown(keyCode, event);
}