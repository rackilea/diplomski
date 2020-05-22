@Override
public void onDestroy(){
    XWalkView view = (XWalkView)findViewById(R.id.xwalkWebView);
    view.onDestroy();
    super.onDestroy();
    finish();
}