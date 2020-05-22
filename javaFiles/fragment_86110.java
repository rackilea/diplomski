// retrieve all players
ArrayList<String> players = mgr.getPlayers(readyGameID);
// randomize the list
Collections.shuffle(players);
// instantiate two arraylists for the teams
ArrayList<String> teamRed = new ArrayList<String>();
ArrayList<String> teamBlue = new ArrayList<String>();

// add the first half of players to teamRed
teamRed.addAll(players.subList(0, players.size() / 2 + players.size()%2));
// and the second half to teamBlue
teamBlue.addAll(players.subList(players.size() / 2 + players.size()%2, players.size()));

// now do whatever you need to do with the two teams