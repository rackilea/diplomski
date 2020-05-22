View view=inflater.inflate(R.layout.fragment_crime_list,container,false);
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.linearLayout);
        View webViewLayout = LayoutInflater.from(getActivity()).inflate(R.layout.webview, linearLayout,false);



        WebView webView = (WebView) webViewLayout.findViewById(R.id.webview1);
        linearLayout.addView(webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String myPdfUrl = "gymnasium-wandlitz.de/vplan/vplan.pdf";
        String url = "https://docs.google.com/viewer?embedded=true&url="+myPdfUrl;
        webView.loadUrl(url);