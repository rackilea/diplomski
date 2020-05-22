try {
    session = jsch.getSession(user, host, port);
}
catch (JSchException e) {
    throw new TransferException("Failed to open session - " + params, e);
}

session.setPassword(password);

//  Create UserInfo instance in order to support SFTP connection to any machine 
//  without a key username and password will be given via UserInfo interface.
UserInfo userInfo = new SftpUserInfo();
session.setUserInfo(userInfo);

try {
    session.connect(connectTimeout);
}
catch (JSchException e) {
    throw new TransferException("Failed to connect to session - " + params, e);
}

boolean isSessionConnected = session.isConnected();