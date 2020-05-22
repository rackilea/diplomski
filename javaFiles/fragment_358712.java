@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    Context context = view.getContext();
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

    // Launch default browser
    context.startActivity(browserIntent);

    return true;
}