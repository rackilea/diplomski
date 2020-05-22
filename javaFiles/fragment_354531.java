try {
    req.setConnectTimeout(TimeUnit.SECONDS.toMillis(10)); 
    req.setReadTimeout(TimeUnit.SECONDS.toMillis(10));

    [...] readData(req);

} catch (SocketTimeoutException e) {
    // do request again
}