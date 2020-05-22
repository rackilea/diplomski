public void addPlayerToSport( String sport, Player player )
{
   List<Player> listPlayer = mapSportToPlayer.get( sport );
   //first time we associate a player to this sport
   if( listPlayer == null )
   {
       listPlayer = new ArrayList<Player>();
   }//if
   listPlayer.add( player );
}//met