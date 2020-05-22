@Override
public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.graphview, container, false);
}

@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    GraphView graph = view.findViewById(R.id.graph); 
    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
            new DataPoint(0, 1),
            new DataPoint(1, 5),
            new DataPoint(2, 3)
     });
     graph.addSeries(series); 
}