public void setColorsViews() {
    if (!colorsFirstTime) {
        view = new Layer(cordova.getActivity());
        redView = new Layer(cordova.getActivity());
        greenView = new Layer(cordova.getActivity());
        blueView = new Layer(cordova.getActivity());

        WindowManager localWindowManager = (WindowManager) cordova.getActivity()
                .getSystemService("window");
        WindowManager.LayoutParams layoutParams = cordova.getActivity().getWindow()
                .getAttributes();
        layoutParams.format = PixelFormat.TRANSLUCENT;

        localWindowManager.addView(view, layoutParams);
        localWindowManager.addView(greenView, layoutParams);
        localWindowManager.addView(redView, layoutParams);
        localWindowManager.addView(blueView, layoutParams);
        colorsFirstTime = true;
        Log.d("display", "views added");
    }
}