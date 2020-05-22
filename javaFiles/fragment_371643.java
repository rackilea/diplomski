@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // ...  
    NavListener navListener = new NavListener();  
}  

private class NavListener implements View.OnClickListener {
    @Override
    public void onNavSelected(View v) {
         switch (v.getId()) {
            case R.id.TabNav1:
                // do something...
            break;
            case R.id.TabNav2:
                // do something else...
            break;
            case R.id.TabNav3:
                // do something...
            break;
            // ...
         }
    }
};