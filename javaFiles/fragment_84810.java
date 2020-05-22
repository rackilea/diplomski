try {
        URL url = new URL(image_URL);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.connect();
        String PATH = Environment.getExternalStorageDirectory().toString();
        Log.v("LOG_TAG", "PATH: " + PATH);
        File file = new File(PATH);
        file.mkdirs();
        String fileName = image.jpg;
        File outputFile = new File(file, fileName);
        FileOutputStream fos = new FileOutputStream(outputFile);
        InputStream is = c.getInputStream();
        byte[] buffer = new byte[1024];
        int len1 = 0;
        while ((len1 = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len1);
        }
        fos.close();
        is.close();
        // Toast.makeText(this, "Downloaded Successfully", 600).show();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }