Intent picIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


        String file_path = Environment.getExternalStorageDirectory().toString() +
                "/" + mContext.getResources().getString(R.string.app_name);

        File dir = new File(file_path);
        if (!dir.exists())
            dir.mkdirs();
       // IMAGE_PATH = new File(dir, mContext.getResources().getString(R.string.app_name) + AppConstants.USER_ID + System.currentTimeMillis() + ".png");

        IMAGE_PATH = new File(dir, mContext.getResources().getString(R.string.app_name) + System.currentTimeMillis() + ".png");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            picIntent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(mContext, mContext.getPackageName()+".fileprovider", IMAGE_PATH));
        }
        else {
            picIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(IMAGE_PATH));
        }

        ((Activity) mContext).startActivityForResult(picIntent, CAMERA_REQUEST);