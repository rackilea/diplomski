BitmapFactory.Options options = new BitmapFactory.Options();

options.inPreferredConfig = Bitmap.Config.ARGB_8888;

Bitmap bitmap = BitmapFactory.decodeFile(food.getImageUrl(), options);
holder.imageView.setImageBitmap(bitmap);