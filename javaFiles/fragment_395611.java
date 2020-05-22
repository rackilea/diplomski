private boolean isLargeDevice(Context context) {
        int screenLayout = context.getResources().getConfiguration().screenLayout;
        screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenLayout) {
        case Configuration.SCREENLAYOUT_SIZE_SMALL:
        case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            return false;
        case Configuration.SCREENLAYOUT_SIZE_LARGE:
        case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            return true;
        default:
            return false;
        }
    }