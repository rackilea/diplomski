CertificatePinner = new CertificatePinner.Builder()
            .add(new URL(url).getHost(), "sha256/<certificate1 fingerprint [base64]>")
            .add(new URL(url).getHost(), "sha256/<certificate2 fingerprint [base64]>")
            .build();
OkHttpClient client;
    client = okHttpClient.newBuilder()
        .certificatePinner(certificatePinner)
        .build();