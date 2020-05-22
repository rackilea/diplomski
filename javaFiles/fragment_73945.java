@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
switch (requestCode) {
case 0:
    if (resultCode == RESULT_OK) {
    try {
    uri = Uri.parse(data.getDataString());
    imageView.setImageUri(uri);
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
    e.printStackTrace();
    }}
    break;
    }
}