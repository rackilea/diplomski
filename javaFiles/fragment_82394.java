public class ScanFragment extends Fragment {

public ScanFragment(){}

 private Camera mCamera;
 private CameraPreview mPreview;
 private Handler autoFocusHandler;
 private static final String TAG_PID = "pid";

 TextView scanText;
 ImageScanner scanner;
 private boolean barcodeScanned = false;
 private boolean previewing = true;
 FrameLayout preview;

 static {
     System.loadLibrary("iconv");
 }

public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState); 
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {

    // previously fragment_home
    View rootView = inflater.inflate(R.layout.fragment_scan, container, false);
    autoFocusHandler = new Handler();
    mCamera = getCameraInstance();
     mPreview = new CameraPreview(this.getActivity(), mCamera, previewCb, autoFocusCB);
    preview = (FrameLayout) rootView.findViewById(R.id.cameraPreview);
    preview.addView(mPreview);

    scanText = (TextView) rootView.findViewById(R.id.scanText);  
    return rootView;
}