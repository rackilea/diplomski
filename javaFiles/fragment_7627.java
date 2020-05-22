public class ConcertFragment extends Fragment implements SurfaceHolder.Callback {

ImageView toto;
ToggleButton btnFlashlight;
RayMenu menu;
View rootView;

private Camera cam;
boolean hasCamera;
Parameters params;
private int REQUEST_IMAGE_CAPTURE;
Bitmap photo;
Uri imageUri;

public ConcertFragment() {
}

public void startCameraIntent() {
    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  
    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE); 
}

@Override
public void onStart() {
    super.onStart();
    SurfaceView preview = (SurfaceView)getView().findViewById(R.id.background);
    SurfaceHolder mHolder = preview.getHolder();
    mHolder.addCallback(this);
}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.concert, menu);
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getCamera();
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    rootView = inflater.inflate(R.layout.fragment_concert, container, false); 
    toto = (ImageView) rootView.findViewById(R.id.toto);
    return rootView;
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode != 0)
    {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            toto.setImageBitmap(photo);

            View content = rootView.findViewById(R.id.toto);
            content.setDrawingCacheEnabled(true);

                Bitmap bitmap = content.getDrawingCache();
                File root = Environment.getExternalStorageDirectory();
                File cachePath = new File(root.getAbsolutePath() + "/DCIM/Camera/image.jpg");
                try {
                    cachePath.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(cachePath);
                    bitmap.compress(CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(cachePath));
                startActivity(Intent.createChooser(share,"Share via"));
        }
        else {
            cam.release();
        }
    }
}    

// Get the camera
   private void getCamera() {
        if (cam != null) {
            try {
                cam = Camera.open();
                params = cam.getParameters();
                cam.startPreview();
                hasCamera = true;

            } catch (RuntimeException e) {
                Log.e("Camera Error. Failed to Open. Error: ", e.getMessage());
                cam.release();
            }
        }
   }