webView.webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            println("shouldOverrideUrlLoading")
            println(request?.url.toString())
            val url :String = request?.url.toString()
            if (url.endsWith("mp4")) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(Uri.parse(url), "video/mp4")
                startActivity(intent)
                return true
            }
            return false
        }
    }
    val videoPath = "http://techslides.com/sample-webm-ogg-and-mp4-video-files-for-html5"
    webView.loadUrl(videoPath)