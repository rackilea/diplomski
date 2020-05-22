@Override
protected void onStop() {
    if (listenerRegistration != null) {
        listenerRegistration.remove();
    }
}