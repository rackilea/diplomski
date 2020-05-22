SuppressWarnings("deprecation")
    @Override
    fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean
    {
        if (url != null && url.startsWith("whatsapp://")) {
            val sendIntent = Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Moon TV");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent)
            return true
            /* ContextCompat.startActivity(sendIntent);return true;*/

        } else {
            return false;
        }