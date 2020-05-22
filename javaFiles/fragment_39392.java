@Override protected void handleControlPropertyChanged(String p) {
    super.handleControlPropertyChanged(p);

    if ("SHOWING".equals(p)) {
        ...
    } else if ("VALUE".equals(p)) {
        /* Some logic for updating the GUI */
    }
}