@Test
public void testTree() {
    LOGGER.debug("testAddWebResource");
    doInTransaction(new TransactionCallable<Void>() {
        @Override
        public Void execute(Session session) {
            LocalFolder rootLocalFolder = new LocalFolder();
            session.persist(rootLocalFolder);
            LocalFolder localFolder1 = new LocalFolder();
            rootLocalFolder.addChild(localFolder1);
            session.persist(localFolder1);
            LocalFolder localFolder11 = new LocalFolder();
            localFolder1.addChild(localFolder11);
            session.persist(localFolder11);

            RemoteFolder rootRemoteFolder = new RemoteFolder();
            session.persist(rootRemoteFolder);
            RemoteFolder remoteFolder1 = new RemoteFolder();
            rootRemoteFolder.addChild(remoteFolder1);
            session.persist(remoteFolder1);
            RemoteFolder remoteFolder11 = new RemoteFolder();
            remoteFolder1.addChild(remoteFolder11);
            session.persist(remoteFolder11);
            return null;
        }
    });
}