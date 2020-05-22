Channel chExec = session.openChannel("exec");
  Channel chSFTP = session.openChannel("sftp");

  chExec.setInputStream(System.in);
  chExec.setOutputStream(System.out);
  chSFTP.setInputStream(System.in);
  chSFTP.setOutputStream(System.out);

  chExec.connect();
  chSFTP.connect();