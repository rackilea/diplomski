public class Ac {

    private GooglePlayServicesClient.OnConnectionFailedListener psConnectionFailedListener =
            new GooglePlayServicesClient.OnConnectionFailedListener() {

                @Override
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    // implementation
                }
            };

    private GooglePlayServicesClient.ConnectionCallbacks psConnectionCallbacks =
            new GooglePlayServicesClient.ConnectionCallbacks() {

                @Override
                public void onConnected(Bundle bundle) {
                    // implementation
                }

                @Override
                public void onDisconnected() {
                    // implementation
                }
            };

    private GoogleApiClient.ConnectionCallbacks googleConnectionCallbacks =
            new GoogleApiClient.ConnectionCallbacks() {

                @Override
                public void onConnected(Bundle bundle) {
                    // implementation
                }

                @Override
                public void onConnectionSuspended(int i) {
                    // implementation
                }
            };

    private GoogleApiClient.OnConnectionFailedListener googleConnectionFailedListener =
            new GoogleApiClient.OnConnectionFailedListener() {

                @Override
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    // implementation
                }
            };
}