String fullpath = Environment.getExternalStorageDirectory() + "/pathtoyourfile"

        // take the path create a bitmap and populate the ImageView with it.
        ImageView iv = (ImageView) v.findViewById(R.id.thumbnail);
        Bitmap bm = BitmapFactory.decodeFile(fullpath);
        iv.setImageBitmap(bm);