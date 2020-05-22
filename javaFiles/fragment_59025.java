private TrustManager[] getWrappedTrustManagers(TrustManager[] trustManagers) {
        final X509TrustManager originalTrustManager = (X509TrustManager) trustManagers[0];
        return new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return originalTrustManager.getAcceptedIssuers();
            }

            public void checkClientTrusted(X509Certificate[] certs,
                    String authType) {
                try {
                    if (certs != null && certs.length > 0) {
                        certs[0].checkValidity();
                    } else {
                        originalTrustManager
                                .checkClientTrusted(certs, authType);
                    }
                } catch (CertificateException e) {
                    Log.w("checkClientTrusted", e.toString());
                }
            }

            public void checkServerTrusted(X509Certificate[] certs,
                    String authType) {
                try {
                    if (certs != null && certs.length > 0) {
                        certs[0].checkValidity();
                    } else {
                        originalTrustManager
                                .checkServerTrusted(certs, authType);
                    }
                } catch (CertificateException e) {
                    Log.w("checkServerTrusted", e.toString());
                }
            }
        } };
    }