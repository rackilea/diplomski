void Save(){  
String folder = "/sdcard/Pictures/MyAppFolder";
       Imageview  view = (ImageView)findViewById(R.id.cachesView);

          view.buildDrawingCache(); 

        Bitmap yourBitmap = view.getDrawingCache();  
          final File myDir = new File(folder);
                myDir.mkdirs();
                final Random generator = new Random();
                int n = 10000;
                n = generator.nextInt(n);
                final String fname = "StyleMe-" + n + ".png";
                File file = new File(myDir, fname);
                if (file.exists())
                    FileOutputStream out = new FileOutputStream(file);
                    yourBitmap.compress(CompressFormat.JPEG, 100, out);
                    out.flush();
                    out.close();
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED,
                            Uri.parse("file://"
                                    + Environment.getExternalStorageDirectory()))); // this will refresh the gallery app.
                    Toast.makeText(getApplication(), "Image Saved", Toast.LENGTH_SHORT)
                            .show();
    }