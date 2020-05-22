public static class MyClusterItem implements ClusterItem {

    private final LatLng mPosition;

    public MyClusterItem(LatLng position) {
        mPosition = position;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}