if(android.os.Build.VERSION.SDK_INT >= 11){
     final android.content.ClipboardManager clipboard =  (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
       if (clipboard.hasPrimaryClip()) {
        // Do stuff
        doSomething(); 
       }
   } else {
     final android.text.ClipboardManager clipboard =(ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
      if (clipboard.hasPrimaryClip()) {
        // Do stuff
        doSomething(); 
       }
   }