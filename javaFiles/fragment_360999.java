JSch jsch = new JSch();
Properties properties = new Properties();
properties.setProperty("StrictHostKeyChecking", "no");

if (privKeyFile != null)
    jsch.addIdentity(privKeyFile, password);

Session session = jsch.getSession(username, host, port);
session.setTimeout(timeout);
session.setConfig(properties);

if (proxy != null)
    session.setProxy(proxy);

if (privKeyFile == null && password != null)
    session.setPassword(password);

session.connect();

ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
channel.connect();