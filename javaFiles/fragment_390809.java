@Override
protected void onResume() {
    super.onResume();

    if (shouldRecreate) {
        recreate();
        shouldRecreate = false;
    }
}