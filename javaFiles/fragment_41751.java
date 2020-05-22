try {
    conn = server.accept();
} catch (SocketTimeoutException e) {
    return 2;
} catch (IOException e) {
    // socket exception will not be recaught
    // even if return statement wasn't used
    return 0;
}
return 1;