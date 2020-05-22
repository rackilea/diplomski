@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View view = super.onCreateView(inflater, container, savedInstanceState);
    GoogleMap map = getMap();

    int radius = 500;

    for(int i=0; i<5; i++){
        map.addCircle(new CircleOptions().center(new LatLng(0,0)).radius(radius).fillColor(0x30000000).strokeWidth(3));
        radius += 500;
    }
    return view;
}