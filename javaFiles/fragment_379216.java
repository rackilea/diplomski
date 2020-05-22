private void downloadImage()
{
    RealmResults<ARDatabase> results = mRealm.where(ARDatabase.class).findAll();

    for(ARDatabase x:results)
    {
        if(!x.getIsDownloaded())
        {
            mdataCollection.add(new DownLoadList(x.getUrlImg(),x.getUid()));
        }
    }

    for(DownLoadList i:mdataCollection)
    {
        Log.e("Link",""+i.getImageUrl());
        Picasso.with(getApplicationContext()).load(i.getImageUrl()).into(getTarget(i));
    }
}

private Target getTarget(DownLoadList downLoadList) {
    Target target = new Target() {
        @Override
        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from)
        {
            Log.e("PICASSO","SUCCESSFUL");

            new Thread(new Runnable() {
                @Override
                public void run() {

                    File sd = getExternalCacheDir();
                    File folder = new File(sd, "/arproject/");
                    if (!folder.exists()) {
                        if (!folder.mkdir()) {
                            Log.e("ERROR", "Cannot create a directory!");
                        } else {
                            folder.mkdirs();
                        }
                    }

                    //File[] fileName = {new File(folder, "one.jpg"), new File(folder, "two.jpg")};


                    File fileName = new File(folder, downLoadList.getUid().toLowerCase()+".jpg");


                    if (!fileName.exists()) {
                        try {
                            fileName.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {

                        try {
                            FileOutputStream outputStream = new FileOutputStream(String.valueOf(fileName));
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                            outputStream.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();

        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable)
        {
            Log.e("PICASSO","FAILED"+errorDrawable.toString());

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }

    }
    return target;
}