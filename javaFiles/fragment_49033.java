override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {

            var overrideUrlLoading = false

            if (url != null && url.startsWith("whatsapp://")) {

                view.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

                overrideUrlLoading = true

            } else {

                view.loadUrl(url)
            }

            return overrideUrlLoading
        }