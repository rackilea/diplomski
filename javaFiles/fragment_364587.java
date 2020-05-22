super.onCreate(savedInstanceState);
setContentView(R.layout.main);

preview = (SurfaceView) findViewById(R.id.preview);
previewHolder = preview.getHolder();
previewHolder.addCallback(surfaceCallback);
previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
addView();