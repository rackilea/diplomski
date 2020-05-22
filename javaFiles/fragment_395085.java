DriveContents file2Cont(DriveContents driveContents, java.io.File file) {
    OutputStream oos = driveContents.getOutputStream();
    if (oos != null) try {
      InputStream is = new FileInputStream(file);
      byte[] buf = new byte[8192];
      int c = 0;
      while ((c = is.read(buf, 0, buf.length)) > 0) {
        oos.write(buf, 0, c);
        oos.flush();
      }
    } catch (Exception e)  {/*handle errors*/}
    finally {
      try {
        oos.close();
      } catch (Exception ignore) { }
    }
    return driveContents;
  }

  DriveContents bytes2Cont(DriveContents driveContents, byte[] buf) {
    OutputStream os = driveContents.getOutputStream();
    try { os.write(buf);
    } catch (IOException e)  {/*handle errors*/}
     finally {
      try { os.close();
      } catch (Exception e) {/*handle errors*/}
    }
    return driveContents;
  }