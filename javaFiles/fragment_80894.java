public class Demo2 extends AppCompatActivity {

private ImageButton ib;
private final int GALLREQ = 1;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.demo4);
}

public void ibC (View view) {

    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    startActivityForResult(galleryIntent , GALLREQ);

}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == GALLREQ && resultCode == RESULT_OK) {
        Uri uri = data.getData();
        ib = (ImageButton) findViewById(R.id.ib);
        Log.e("Uri", "*******" + uri.getPath());
        ib.setImageURI(uri);
    }

}
}