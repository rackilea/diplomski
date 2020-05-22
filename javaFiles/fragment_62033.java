/* ConnectionSpec.MODERN_TLS is the default value */
List tlsSpecs = Arrays.asList(ConnectionSpec.MODERN_TLS);

/* providing backwards-compatibility for API lower than Lollipop: */
if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
    tlsSpecs = Arrays.asList(ConnectionSpec.COMPATIBLE_TLS);
}

OkHttpClient client = new OkHttpClient.Builder()
    .connectionSpecs(tlsSpecs)
    .build();