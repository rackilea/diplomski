View rootView = inflater.inflate(layoutChooser(), container, false);

private int layoutChooser() {
        if (isNetworkAvailable()) {
            return R.layout.fragment_home;
        } else {
            return R.layout.fragment_NULL;
        }
    }