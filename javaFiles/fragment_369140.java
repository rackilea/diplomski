int port = request.getServerPort();

if (request.getScheme().equals("http") && port == 80) {
    port = -1;
} else if (request.getScheme().equals("https") && port == 443) {
    port = -1;
}

URL serverURL = new URL(request.getScheme(), request.getServerName(), port, "");