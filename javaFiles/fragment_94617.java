@Override
public void onPageFinished(WebView view, String url)
{
    System.out.println("onPageFinished: " + url);
    if ("about:blank".equals(url) && view.getTag() != null)
    {
        view.loadUrl(view.getTag().toString());
    }
    else
    {
        view.setTag(url);
    }
}