@Override
public void onBackPressed() {
    finishWithAnimate();
    // get your fragment
    if(fragment!=null) fragment.onRefreshAuctions();
}