@Override
protected void onCreate(Bundle savedInstanceState)  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.your_layout_id);
    gridSurfaceView = (GridSurfaceView) findViewById(R.id.gridsurfaceview);

    gridSurfaceView.setCoordsProvider(new CoordsProvider(){
        @Override
        public double getXCoord(){return xCoord;}

        @Override
        public double getYCoord(){return yCoord;}
    });