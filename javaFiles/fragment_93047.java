public class MyClusterManager<T extends ClusterItem> extends ClusterManager<T> {
  @Override
  public void onCameraIdle() {
    if (mRenderer instanceof GoogleMap.OnCameraIdleListener) {
      ((GoogleMap.OnCameraIdleListener) mRenderer).onCameraIdle();
    }
    CameraPosition position = mMap.getCameraPosition();
    mPreviousCameraPosition = mMap.getCameraPosition();
    cluster();
  }
}