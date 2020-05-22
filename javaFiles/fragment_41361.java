class Team{
   List<Player> players = new ArrayList<Player>();

   public void addPlayer(Player p, String position){
      p.position = position;
      players.add(p);
   }
}