while (gameRunning) {
  for (GameEntity e in gameWorldEntities) {
    e.update(timePassed);  
  }
  for (GameEntity e in gameWorldEntities) {
    e.draw();
  }
}