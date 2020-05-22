if (player.gold > 10){
   player.setGold(gold - 10);
   Ship newShip = new Ship();
   player.addShip(newShip);  // I suppose you have cascade insert otherwise you have to save your transient ship
}

session.getTransaction().commit();