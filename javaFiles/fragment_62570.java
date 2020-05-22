ParseObject gameScore = new ParseObject("GameScore");
gameScore.put("score", 1337);
gameScore.put("playerName", "Sean Plott");

gameScore.put("cheatMode", false);
gameScore.saveInBackground()`;