Options opts = new Options(); 
  opts.inJustDecodeBounds = true; 
  BitmapFactory.decodeFile(path, opts); 
  Log.e("optwidth",opts.outWidth+""); 
  opts.inJustDecodeBounds = false; 
  if(opts.outWidth>500){ 
          opts.inSampleSize = 4; 
          mBitmap = BitmapFactory.decodeFile(path, opts); 
  } 
  else mBitmap = BitmapFactory.decodeFile(path, opts);