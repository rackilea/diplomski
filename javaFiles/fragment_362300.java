HttpURLConnection connection;
final String INFO_HASH = "info_hash";
final String PEER_ID = "peer_id";
final String PORT = "port";
final String EVENT = "event";
final String UPLOADED = "uploaded";
final String DOWNLOADED = "downloaded";
final String LEFT = "left";
final String NO_PEER_ID = "no_peer_id";
final String COMPACT = "compact";

try {
    byte[] peerId = new byte[20];
    Random rnd = new Random();
    rnd.nextBytes(peerId);

    URI uri = new URIEncodeBuilder(metaInfo.getAnnounce())
            .addParameter(INFO_HASH, new String(metaInfo.getInfoHash(), "ISO-8859-1"), "ISO-8859-1")
            .addParameter(PEER_ID, "-TO0042-0ab8e8a31019")
            .addParameter(PORT, "6881")
            .addParameter(EVENT, "started")
            .addParameter(UPLOADED, "0")
            .addParameter(DOWNLOADED, "0")
            .addParameter(LEFT, "1028128768")
            .addParameter(COMPACT, "1")
            .addParameter(NO_PEER_ID, "0").build();
    log.info("Maybe: " + uri.toURL().toString());
    connection = (HttpURLConnection) uri.toURL().openConnection();
} catch (MalformedURLException e) {
    throw new RuntimeException("Invalid torrent file: illegal announce in torrent file");
} catch (URISyntaxException e) {
    throw new RuntimeException("Couldn't build URI: illegal announce in torrent file");
}