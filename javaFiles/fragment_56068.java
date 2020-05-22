// create OnAmbilWarnaListener instance
// new color can be retrieved in onOk() event
OnAmbilWarnaListener onAmbilWarnaListener = new OnAmbilWarnaListener() {
    @Override
    public void onCancel(AmbilWarnaDialogFragment dialogFragment) {
        Log.d("TAG", "onCancel()");
    }

    @Override
    public void onOk(AmbilWarnaDialogFragment dialogFragment, int color) {
        Log.d("TAG", "onOk(). Color: " + color);

        MainActivity.this.mColor = color;
    }
};

// create new instance of AmbilWarnaDialogFragment and set OnAmbilWarnaListener listener to it
// show dialog fragment with some tag value
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
AmbilWarnaDialogFragment fragment = AmbilWarnaDialogFragment.newInstance(mColor);
fragment.setOnAmbilWarnaListener(onAmbilWarnaListener);

fragment.show(ft, "color_picker_dialog");