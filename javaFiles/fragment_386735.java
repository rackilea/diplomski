InputStream is = getResources().openRawResource(R.raw.haarcascade_frontalface_alt);
FileOutputStream os = null;
        try {
            os = new FileOutputStream(mCascadeFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        byte[] buffer = new byte[4096];
        int bytesRead;
        try {
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }