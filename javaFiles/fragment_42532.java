try
  {
    code = readData();

    if (code == null) continue; 
    lastRead = System.currentTimeMillis();

    // whenever you receive the heart beat reply, just ignore it.
    if (MSG_HEARTBEAT.equals(code)) continue;

    // todo: handle other messages
  }
  catch (SocketTimeoutException ste)
  {
    // in a typical situation the soTimeout is about 200ms
    // the heartbeat interval is usually a couple of seconds.
    // and the heartbeat timeout interval a couple of seconds more.
    if ((heartbeatTimeoutInterval > 0) &&
        ((System.currentTimeMillis() - lastRead) > heartbeatTimeoutInterval))
    {
      // no reply to heartbeat received.
      // end the loop and perform a reconnect.
      break;
    }
  }