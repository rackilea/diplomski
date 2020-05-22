private String url = "";




 protected void onCreate(Bundle savedInstanceState) {
.........................................
.......................................
............................
}


@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
{
    super.onCreateContextMenu(menu, v, menuInfo);

    WebView w = (WebView)v;
    WebView.HitTestResult result = w.getHitTestResult();


    if(result.getType() == WebView.HitTestResult.SRC_ANCHOR_TYPE)
    {
        menu.addSubMenu(4, 4, 4, "Open in browser");
        url = result.getExtra();

    }

}

@Override
public boolean onContextItemSelected(MenuItem item){
    if (item.getTitle()=="Open in browser"){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    return true;
}