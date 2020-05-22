@Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int colorFrom = getResources().getColor(R.color.white);
        int colorTo = getResources().getColor(R.color.colorFrame2);
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getView().findViewById(R.layout.fragmentlayout2).setBackgroundColor((int) animator.getAnimatedValue());

            }

        });
        colorAnimation.start();
    return inflater.inflate(R.layout.fragmentlayout2, null);
    // ^^^^^^^^
    }