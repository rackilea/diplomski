if (imagesPathList != null) {
            if (imagesPathList.size() >= 1) {
                for (int i = 0; i < imagesPath.length; i++) {

                    String strImg = imagesPath[i];
                    File f = new File("" + strImg);
                    Log.e("File", "" + f);
                    doFileUpload(f);
                    Log.d("saveimages", "" + imagesPathList);
                }
                Toast.makeText(
                        MainActivity.this,
                        imagesPathList.size()
                                + " no of images are selected",
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(
                        MainActivity.this,
                        imagesPathList.size() + " no of image are selected",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, " no images are selected",
                    Toast.LENGTH_SHORT).show();
        }
        break;

}
}
public void doFileUpload(File f) {
    FTPClient client = new FTPClient();

    try {
        client.connect(FTP_HOST, 21);
        Log.e("clientconnect", "" + client);
        client.login(FTP_USER, FTP_PASS);
        Log.e("clientlogin", "" + client);
        client.setType(FTPClient.TYPE_BINARY);
        Log.e("clienttype", "" + client);
        client.changeDirectory("/ramesh2/");
        Log.i("", "$$$$$$$$$$$$$$$$$" + ("/ramesh2/"));
        // int reply = client.getReplyCode();

        client.upload(f, new MyTransferListener());

        // Log.e("filenameupload", "" + photoFile);
        Log.e("clientupload", "" + client);
        // Log.e("file",""+fileName);

    } catch (Exception e) {
        e.printStackTrace();
        try {
            client.disconnect(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

}
public class MyTransferListener implements FTPDataTransferListener {

    public void started() {

        // btn.setVisibility(View.GONE);
        // Transfer started
        Toast.makeText(getApplicationContext(), " Upload Started ...",
                Toast.LENGTH_SHORT).show();
        // System.out.println(" Upload Started ...");
    }

    public void transferred(int length) {

        // Yet other length bytes has been transferred since the last time
        // this
        // method was called
        Toast.makeText(getApplicationContext(),
                " transferred ..." + length, Toast.LENGTH_SHORT).show();
        // System.out.println(" transferred ..." + length);
    }

    public void completed() {

        // btn.setVisibility(View.VISIBLE);
        // Transfer completed

        Toast.makeText(getApplicationContext(), " completed ...",
                Toast.LENGTH_SHORT).show();
        // System.out.println(" completed ..." );
    }

    public void aborted() {

        // btn.setVisibility(View.VISIBLE);
        // Transfer aborted
        Toast.makeText(getApplicationContext(),
                " transfer aborted , please try again...",
                Toast.LENGTH_SHORT).show();
        // System.out.println(" aborted ..." );
    }

    public void failed() {

        // btn.setVisibility(View.VISIBLE);
        // Transfer failed
        System.out.println(" failed ...");
    }
    // Jibble.
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == PICK_IMAGE_MULTIPLE
            && resultCode == Activity.RESULT_OK && null != data) {
        // uri=data.getData();
        // System.out.println("Current image Path is ----->" +
        // getRealPathFromURI(uri));
        imagesPathList = new ArrayList<String>();
         imagesPath = data.getStringExtra("data").split("\\|");
        try {
            lnrImages.removeAllViews();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        for (int i = 0; i < imagesPath.length; i++) {
            Log.e("imagesPath can", "" + imagesPath);
            imagesPathList.add(imagesPath[i]);
            Log.w("imagesPathList are", "" + imagesPathList);
            yourbitmap = BitmapFactory.decodeFile(imagesPath[i]);
            Log.d("yourbitmap is", "" + yourbitmap);

            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(yourbitmap);
            imageView.setAdjustViewBounds(true);
            lnrImages.addView(imageView);

            String listString = "";

            for (String s : imagesPathList) {
                listString += s + "\t";
            }
            j = listString.toString();
            uri = Uri.parse(j);
            r = uri.toString();
            Log.d("mnmnmnmnmnmnmhjjuigyigsuiagducfuducgfasicfgds", "" + r);
            Log.d("anananananananananananananananananananananannananand",
                    "" + uri);