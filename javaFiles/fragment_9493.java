public void addingView (View view){ 
        LinearLayout top = (LinearLayout) findViewById(R.id.top);
        LinearLayout newLayout = new LinearLayout (this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        newLayout.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, 50));
        top.addView(newLayout,params);
}