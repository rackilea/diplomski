@Override
public void onBackPressed() {
    if(getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)) {
        //this is the last activity on stack
        doSomethingSpecial();
    } else {
        super.onBackPressed();
    }
}