@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    String url = "http://winn-brown.co.uk/";
    WebView view = (WebView) rootView.findViewById(R.id.webView);
    view.getSettings().setJavaScriptEnabled(true);
    view.loadUrl(url);

    return rootView ;
}