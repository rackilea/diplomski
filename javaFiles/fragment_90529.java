@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Uri PathHolder = data.getData();
    FileInputStream fileInputStream = null;
    StringBuilder text = new StringBuilder();
    try {
        InputStream inputStream = getContentResolver().openInputStream(PathHolder);
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        String mLine;
        while ((mLine = r.readLine()) != null) {
            text.append(mLine);
            text.append('\n');
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}