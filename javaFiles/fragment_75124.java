@Override
public WebResourceResponse shouldInterceptRequest(WebView view,
    String url) {
    String ext = MimeTypeMap.getFileExtensionFromUrl(url);
    String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ext);
    if (mime == null) {
        return super.shouldInterceptRequest(view, url);
    } else {
        HttpURLConnection conn = (HttpURLConnection) new URL(
                                                 url).openConnection();
        conn.setRequestProperty("User-Agent", userAgent);
        return new WebResourceResponse(mime, "UTF-8",
                                                 conn.getInputStream());
    }
}