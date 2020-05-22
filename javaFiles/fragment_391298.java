Iterator<Game> i = appDeleg.getGlobalGames().getGames().iterator();

Game game;
while(i.hasNext()) {
    game = i.next();
    if(game.getOwner().getId().equals(params[0]))
          i.remove();
    }
}