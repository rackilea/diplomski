@Override
protected byte[] doInBackground(Void... params) {
    InputStream input;
    try{
        input = download(this.url);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = input.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos.toByteArray();
    }
    catch (MalformedURLException e) { Toast.makeText(mContext, "Ошибка загрузки "+url, Toast.LENGTH_SHORT).show(); return null; }
    catch (IOException e){ Toast.makeText(mContext, "Ошибка загрузки "+url, Toast.LENGTH_SHORT).show(); return null; }
}