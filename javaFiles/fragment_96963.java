class MyDialogFragment extends DialogFragment
{
@Override
public Dialog onCreateDialog(Bundle savedInstanceState)
{
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setTitle("Clear cache memory");
builder.setMessage("Do you want to delete cache memory ?");
builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() 
  {
        @Override
        public void onClick(DialogInterface p1, int p2)
        {
            //context.deleteDatabase("webview.db");
            //context.deleteDatabase("webviewCache.db");
            // TODO: Implement this method
            WebView browser = (WebView) getView().findViewById(R.id.mainWebView1);
            browser.clearHistory();
            browser.clearFormData();
            browser.clearCache(true);
        }


    });