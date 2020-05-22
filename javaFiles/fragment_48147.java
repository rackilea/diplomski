ImageLocation = listFile[position].getAbsolutePath();

                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                            Bitmap bitmap = BitmapFactory.decodeFile(ImageLocation, options);


                            WallpaperManager myWallpaperManager 
                            = WallpaperManager.getInstance(getApplicationContext());
                            try {
                                myWallpaperManager.setBitmap(bitmap);
                                Toast.makeText(MyWallpapers.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                Toast.makeText(MyWallpapers.this, "Error", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }