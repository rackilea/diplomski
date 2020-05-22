if(getLastNonConfigurationInstance() != null) {

        bmp = (Bitmap)getLastNonConfigurationInstance();

        alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());

        choosenImageView.setNewImage(alteredBitmap, bmp);
    }