if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && locMan != null) {

            String provider;

            provider = locMan.getProvider(LocationManager.NETWORK_PROVIDER).getName();

            if (Looper.myLooper() == null) {
                Looper.prepare();
            }

            int count = 5;
            for (int i = 0; i < count; i++) {

                locMan.requestSingleUpdate(provider, null, Looper.myLooper());
                location = locMan.getLastKnownLocation(provider);

                if (location != null) {
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }