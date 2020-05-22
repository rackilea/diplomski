JSch jsch = new JSch();
    Session session = jsch.getSession( user, host, port );
    session.setConfig( "PreferredAuthentications", "password" );
    session.setPassword( pass );
    session.connect( FTP_TIMEOUT );
    Channel channel = session.openChannel( "sftp" );
    ChannelSftp sftp = ( ChannelSftp ) channel;
    sftp.connect( FTP_TIMEOUT );