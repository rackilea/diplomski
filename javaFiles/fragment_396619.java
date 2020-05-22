SSHClient ssh = new SSHClient();
ssh.loadKnownHosts();
ssh.connect("host");
try {
    ssh.authPassword("username", "password");
    SFTPClient sftp = ssh.newSFTPClient();
    try {
        sftp.put(new FileSystemFile("/path/of/local/file"), "/path/of/ftp/file");
    } finally {
        sftp.close();
    }
} finally {
    ssh.disconnect();
}