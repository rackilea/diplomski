public class EarnFragment extends Fragment {
WebView mWebView;
RelativeLayout noConnection;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

View v=inflater.inflate(R.layout.fragment_earn, container, false);
mWebView = (WebView) v.findViewById(R.id.webview);
noConnection = (RelativeLayout)v.findViewById(R.id.noConnection);

// Enable Javascript
WebSettings webSettings = mWebView.getSettings();
webSettings.setJavaScriptEnabled(true);

if(checkInternetConnection(getActivity())){
 noConnection.setVisibility(View.GONE);
 mWebView.setVisibility(View.VISIBLE);
 mWebView.loadUrl("https://demo.hazzardweb.com/easylogin-pro/");

}else{
 noConnection.setVisibility(View.VISIBLE);
 mWebView.setVisibility(View.GONE);
}


// Force links and redirects to open in the WebView instead of in a browser
mWebView.setWebViewClient(new WebViewClient());

return v;
}