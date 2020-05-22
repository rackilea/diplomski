public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.atcsectionweb2, container, false);

    wv = (WebView) v.findViewById(R.id.webview);
    pd = (ProgressBar) v.findViewById(R.id.pBar);
    spLoadFrom = (Spinner) v.findViewById(R.id.Spinner02);
    (...)

    return v;
 }