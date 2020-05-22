ContextThemeWrapper themedContext;
if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ) {
    themedContext = new ContextThemeWrapper( FreeDraw.this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar );
}
else {
    themedContext = new ContextThemeWrapper( FreeDraw.this, android.R.style.Theme_Light_NoTitleBar );
}
AlertDialog.Builder builder = new AlertDialog.Builder(themedContext);