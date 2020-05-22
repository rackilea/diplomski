@Override
      public void onCreate(Bundle icicle) {
      super.onCreate(icicle);

     setContentView(R.layout.myscreen);

     Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotation);
     LayoutAnimationController animController = new LayoutAnimationController(rotateAnim, 0);
     FrameLayout layout = (FrameLayout)findViewById(R.id.MyScreen_ContentLayout);
     layout.setLayoutAnimation(animController);
 }