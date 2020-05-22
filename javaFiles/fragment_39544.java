OutputStream someOutput = null;
try {
    someOutput = /* a new stream */;

    /* write */

} catch (Exception e) {
    /* and do something with ALL exceptions */

} finally {
    if (someOutput != null) someOutput.close();
}