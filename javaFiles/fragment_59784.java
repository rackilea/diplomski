private void reopenWithWALSetTo(final boolean useWAL) {
    db.getStorage().close(true, false);
    db.close();
    OGlobalConfiguration.USE_WAL.setValue(useWAL);
    db = new ODatabaseDocumentTx(dbURL);
    db.open("admin", "admin");
}