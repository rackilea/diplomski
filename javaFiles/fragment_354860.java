ViewGroup vg = (ViewGroup) activity.getContentView();
for(int i=0; i<vg.getChildCount(); i++) {
    View v = vg.getChildAt(i);
    if(v instanceof StatusBar) {
        // do something interesting.
    }
}