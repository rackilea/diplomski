if(android.os.Build.VERSION.SDK_INT >= 11){
clipboard = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
}else {
 clipboard = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
}
 if (clipboard.hasPrimaryClip()) {
// Do stuff
}