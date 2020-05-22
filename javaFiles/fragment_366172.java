@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_blackboard, container, false);
  WebView myWebView = (WebView) rootView.findViewById(R.id.webview);
    myWebView.loadUrl("http://www.example.com");
    return rootView;
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}