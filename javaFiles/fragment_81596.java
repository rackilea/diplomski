Room nextRoom = player.getCurrentRoom().getExit( dir );
if( nextRoom == null )
  {
    System.out.println( "You bump into a wall. Ouch!" );
  }
else
  {
    player.setCurrentRoom( nextRoom );
    System.out.println( "You arrive in "+nextRoom );
  }