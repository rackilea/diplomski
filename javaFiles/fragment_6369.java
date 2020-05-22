GraphView graph = (GraphView) findViewById(R.id.graph);
    graph.removeAllSeries();
    LineGraphSeries<DataPoint> mSeries1 = new LineGraphSeries<DataPoint>(new DataPoint[] {
            new DataPoint(1, 1),
            new DataPoint(2, 5),
            new DataPoint(3, 3),
            new DataPoint(4, 2),
            new DataPoint(5, mCigCount)
    });
    LineGraphSeries<DataPoint> series = mSeries1;
    graph.addSeries(series);