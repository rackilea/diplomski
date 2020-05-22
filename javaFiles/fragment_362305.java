public MapView(Context context, int viewWidth, int viewHeight, DataClass tilesProvider, Bitmap positionMarker): base(context)
    {
        //base(context);
        //super(context);


        //base.Context(context);
        //base unexplained use of super that 

        this.context = context;

        this.tileProvider = tilesProvider;

        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;

        this.positionmarker = positionMarker;

        tileManager = new TilesManager(256, viewWidth, viewHeight);

        initPaint();

        fetchTiles();


        //return base.(context, viewWidth, viewHeight, tilesProvider, tilesManager);

    }