/*
   * Return a list of #num players currently connected. (if #num == 0: return
   * all players)
   */
  public ArrayList<String> xmpp_playerlist(int num) {

    try {
      if (!connection.isConnected())
        connection.connect();

      if (!connection.isAuthenticated())
        connection.login(user, pass);

    } catch (XMPPException e) {
      Log.w("Cannot connect to XMPP server with default admin username and password.", "0");
      e.printStackTrace();
    }

    ArrayList<String> players = new ArrayList<String>();
    roster = connection.getRoster();
    Collection<RosterEntry> entries = roster.getEntries();

    for (RosterEntry entry : entries) {
      players.add(entry.getName());
    }
    Log.w("**Number Users: " + roster.getEntryCount(), "0");

    return players;

  }