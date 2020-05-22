webView.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent e) -> {
    if (e.getCode() == KeyCode.ADD || e.getCode() == KeyCode.EQUALS
            || e.getCode() == KeyCode.PLUS) {
        System.out.println("+");
        webView.setZoom(webView.getZoom() * 1.1);
    }
    else if(e.getCode() == KeyCode.SUBTRACT || e.getCode() == KeyCode.MINUS ){
        System.out.println("-");
        webView.setZoom(webView.getZoom() / 1.1);
    }
});