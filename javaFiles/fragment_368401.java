public static arrivi newInstance(String[] dataA, String[] dataB) {
    arrivi fragment = new arrivi();

    Bundle bundle = new Bundle();
    bundle.putStringArray(arrivi.EXTRA_DATA_A, dataA);
    bundle.putStringArray(arrivi.EXTRA_DATA_B, dataB);

    fragment.setArguments(bundle);
    return fragment;
}