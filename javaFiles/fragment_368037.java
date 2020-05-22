if (ff.isDirectory()) {
    //here instead of f you should put ff
     scanForEpubs(ff);
 }else{
      if (ff.isFile() && ff.getName().endsWith(".epub")) {
            Log.d(TAG, "scanForEpubs: " + ff.toString());
      }
 }