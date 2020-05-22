@Override
protected void onStop() {
    super.onStop();

    if (listenerReg != null) {
        listenerReg.remove();
    }
}