@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.imageView);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.ROTATION, 0.0f, 360.0f);

        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(Animation.INFINITE);
        objectAnimator.setInterpolator(new LinearInterpolator());

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                view.animate()
                        .alpha(0.0f)
                        .setDuration(1000);
            }
        });

        objectAnimator.start();

        view.setOnClickListener((v) -> objectAnimator.cancel());

    }