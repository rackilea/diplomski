if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
    View rootView = inflater.inflate(R.layout.fragment_sub_page01, container, false);
    mWebView = (WebView) rootView.findViewById(R.id.webview);
    mWebView.loadUrl("http://www.google.com")
    return rootView;
}