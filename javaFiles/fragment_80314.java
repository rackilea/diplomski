private String readTxt() {
    InputStream inputStream = getResources().openRawResource(R.raw.My_html_file);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int i;
    try {
        i = inputStream.read();
        while (i != -1) {
            byteArrayOutputStream.write(i);
            i = inputStream.read();
        }
        inputStream.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return byteArrayOutputStream.toString();
  }