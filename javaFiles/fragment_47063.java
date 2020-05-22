for (int tries = 1; ; tries++) {
    Connection conn = null;
    try {
        // attempt to connect
        // do stuff
    } catch (SocketException ex) {
        if (/* timed out */ && tries < MAX_TRIES) {
            continue;
        }
        // report exception
    } finally {
        if (conn != null) {
            // close it
        }
    }
    break;
}