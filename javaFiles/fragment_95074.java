mClusterManager.setRenderer(new CustomRenderer<YOUR_TYPE>(getActivity(), googleMap, mClusterManager));

class CustomRenderer<T extends ClusterItem> extends DefaultClusterRenderer<T> {
    public CustomRenderer(Context context, GoogleMap map, ClusterManager<T> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster<T> cluster) {
        //start clustering if at least 2 items overlap
        return cluster.getSize() > 1;
    }
 ...
}