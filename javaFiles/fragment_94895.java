try (ClientSession session = client.connect(user, host, port).verify(timeout).getSession()) {
    session.addPasswordIdentity(password);
    session.auth.verify(timeout);

    // User-specific factory
    try (SftpClient sftp = DefaultSftpClientFactory.INSTANCE.createSftpClient(session)) {
        // use sftp here
    }
}