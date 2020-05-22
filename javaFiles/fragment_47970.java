private class MyWebViewClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getSupportActionBar().getThemedContext());
        AlertDialog alertDialog = builder.create();
        String message = "SSL Certificate error. ";
        switch (error.getPrimaryError()) {
            case SslError.SSL_UNTRUSTED:
                message += "The certificate authority is not trusted.";
                break;
            case SslError.SSL_EXPIRED:
                message += "The certificate has expired.";
                break;
            case SslError.SSL_IDMISMATCH:
                message += "The certificate Hostname mismatch.";
                break;
            case SslError.SSL_NOTYETVALID:
                message += "The certificate is not yet valid.";
                break;
        }

        Log.d(TAG, message);

        message += " Do you want to continue anyway?";
        alertDialog.setTitle("SSL Certificate Error");
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Ignore SSL certificate errors
                handler.proceed();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handler.cancel();
            }
        });
        alertDialog.show();
    }
}