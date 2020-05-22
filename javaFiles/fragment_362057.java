@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.cam1, container, false);
    CamView = (SurfaceView) view.findViewById(R.id.Cam1_CamVIew);

    up = (Button) view.findViewById(R.id.Cam_up);
    dowm = (Button) view.findViewById(R.id.Cam_down);
    right = (Button) view.findViewById(R.id.Cam_right);
    left = (Button) view.findViewById(R.id.Cam_left);

    up.setOnClickListener(Camera_Fragment.this);
    dowm.setOnClickListener(Camera_Fragment.this);
    right.setOnClickListener(Camera_Fragment.this);
    left.setOnClickListener(Camera_Fragment.this);

    Cam_Play();   //< ----------------( ADD IT HERE )

    return view;