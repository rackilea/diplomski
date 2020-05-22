public void updateUI(List<MyCluster> clusters) {
        myClusterManager.clearItems();

        for (int i = 0; i < clusters.size(); i++) {
            myClusterManager.addItem(clusters.get(i));
         //   myClusterManager.setRenderer(new PlaceRender(context, map, myClusterManager));

    }
    myClusterManager.onCameraChange(map.getCameraPosition());
}