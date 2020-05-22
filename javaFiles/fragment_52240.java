public class Camactivity extends Activity {

    private File imageFile;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);//use intent and pass in mediastore
        //mediastore is a databases where image and video are stores and link

        imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "BreedingGround.bmp");
/*link to a directory - pass in directory where you want to save the pictures and names of the file*/

        Uri tempuri = Uri.fromFile(imageFile);//Convert imageFile to a Uri
        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, tempuri);//location where u want the image file to be save after taking photo
        intent.putExtra(android.provider.MediaStore.EXTRA_VIDEO_QUALITY, 1);//quality of out image, 1 means high quality image

        startActivityForResult(intent, 0);//Request code 0 to identify who send the request

    } 

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            // TODO: Handle camera intent result
        }
    }



}