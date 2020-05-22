public class MapFragment extends Fragment  {

private static final String TAG = MapFragment.class.getSimpleName();
private MapView mapView;


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.new_mapview, container, false);

    // Gets the MapView from the XML layout and creates it
    mapView = (MapView) view.findViewById(R.id.mapview);
    mapView.onCreate(savedInstanceState);

    return view;
}


@Override
public void onPause() {
    mapView.onPause();
    super.onPause();
}


@Override
public void onResume() {
    mapView.onResume();
    super.onResume();
}

@Override
public void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
}

@Override
public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
}
}