public ReplicationListener pullAllAsync(Databases db_name) {
    try {
        URI uri = db_name.getServerURI();

        DocumentStore ds = DocumentStore.getInstance(new File(db_name.getMobilePath(), db_name.toString()));
        Replicator replicator = ReplicatorBuilder
                .pull()
                .from(uri)
                .to(ds)

                //WORKAROUND: forces BasicAuthentication method instead of CookieAuthentication
                .addRequestInterceptors(new BasicAuthInterceptor(uri.getRawUserInfo()))
                .build();

        ReplicationListener listener = new ReplicationListener(replicator);
        replicator.getEventBus().register(listener);
        replicator.start();
        return listener;
    } catch (Exception e) {
        e.printStackTrace();
        LogRepository.getInstance().escribirLog(LogRepository.TipoLog.ERROR, null, e, true);
        return null;
    }
}