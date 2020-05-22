Bitmap topass=Util.takeScreenShot(this);
                try {
                    //Write file
                    String filename = "bitmap.png";
                    FileOutputStream stream = this.openFileOutput(filename, Context.MODE_PRIVATE);
                    topass.compress(Bitmap.CompressFormat.PNG, 100, stream);

                    //Cleanup
                    stream.close();
                    topass.recycle();
                } catch (Exception e) {
                    e.printStackTrace();
                }