try {
        URL url = new URL("http://..somepath url../favicon.ico");
        Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
    } catch(IOException e) {
        System.out.println(e);
    }