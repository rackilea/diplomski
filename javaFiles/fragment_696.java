Intent intent = getIntent();
if (intent != null) {
    boolean showStuff = intent.getBooleanExtra("showStuff", false);
    if (showStuff) {
         showStuff();
     }
}