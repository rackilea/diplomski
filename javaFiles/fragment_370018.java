@Override
public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    //initialise the path here
    mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
    mFileName += "/audiorecordtest.3gp";

    //rest of the code