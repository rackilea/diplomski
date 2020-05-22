@Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      arFragment = (ArFragment) 
      getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
      fitToScanView = findViewById(R.id.image_view_fit_to_scan);
   arFragment.getArSceneView().getScene().addOnUpdateListener(this::onUpdateFrame);

    /*** Add HelloSceneform functionality here vvvvvvvvv **/

    // When you build a Renderable, Sceneform loads its resources in
    // the background while returning a CompletableFuture.
    // Call thenAccept(), handle(), or check isDone() before calling get().
    ModelRenderable.builder()
            .setSource(this, R.raw.andy)
            .build()
            .thenAccept(renderable -> andyRenderable = renderable)
            .exceptionally(
                    throwable -> {
                      Toast toast =
                              Toast.makeText(this,
                             "Unable to load andy renderable", Toast.LENGTH_LONG);
                      toast.setGravity(Gravity.CENTER, 0, 0);
                      toast.show();
                      return null;
                    });

    arFragment.setOnTapArPlaneListener(
            (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
              if (andyRenderable == null) {
                return;
              }

              // Create the Anchor.
              Anchor anchor = hitResult.createAnchor();
              AnchorNode anchorNode = new AnchorNode(anchor);
              anchorNode.setParent(arFragment.getArSceneView().getScene());

              // Create the transformable andy and add it to the anchor.
              TransformableNode andy = new TransformableNode(arFragment.getTransformationSystem());
              andy.setParent(anchorNode);
              andy.setRenderable(andyRenderable);
              andy.select();
            });
  }