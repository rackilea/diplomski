public static final Bitmap getBitmap(ContentResolver cr, Uri url)
                throws FileNotFoundException, IOException {
            InputStream input = cr.openInputStream(url);
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            input.close();
            return bitmap;
        }