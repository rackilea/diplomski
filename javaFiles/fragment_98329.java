FsShell shell=new FsShell(conf);
      try {
        shell.run(new String[]{"-chmod","-R","777","user/usr1/data"});
      }
     catch (  Exception e) {
        LOG.error("Couldnt change the file permissions ",e);
        throw new IOException(e);
      }