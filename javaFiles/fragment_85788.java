@Override 
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View fragView = inflater.inflate(R.layout.graphview, container, false); //inflate up here and assign to variable

    GraphView graph = fragView.findViewById(R.id.graph); //change getActivity() to fragView
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3)
    });
    graph.addSeries(series);
    return fragView; //return fragView
}