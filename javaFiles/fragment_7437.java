public void sayAtPlace(Place place, String text, FullscreenActivity target) {
        synchronized (players) {
            Iterator<Player> ls = players.iterator();
            while (ls.hasNext()) {
                Player p = ls.next();
                if (p.currentPlace() == place) {
                    p.say(text, target); //FIXME does this always work???
                }
            }
        }
    }