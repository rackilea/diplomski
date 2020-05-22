final HttpsURLConnection mockUrlConnection = PowerMockito.mock(HttpsURLConnection.class);
PowerMockito.when(mockUrlConnection, "getResponseCode").thenReturn(200);
PowerMockito.when(mockUrlConnection, "getOutputStream").thenReturn(outputStream);

// Replace the HttpsURLConnection factory with one that returns our mock HttpsURLConnection
HttpsUrlConnectionProvider mockConnFactory = new HttpsUrlConnectionProvider() {
    public HttpsURLConnection getHttpsURLConnection(String dialogUri) throws
            IOException {
       return mockUrlConnection;
    }
};
dialog.setHttpsUrlConnectionProvider(mockConnFactory);