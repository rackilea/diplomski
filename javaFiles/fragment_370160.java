boolean spawnTime=0;

void spawnEnemy(){
  Rectangle rect = new Rectangle();
  rect.x = Gdx.graphics.getWidth()/2;
  rect.y = Gdx.graphics.getHeight();
  rect.setSize(50,50);
  myList.add(rect);
}

spawnTime+=Gdx.graphics.getDeltaTime();

//call spawnEnemy function every second
if(spawnTime>=1){
  spawnEnemy();
  spawnTime=0;
}

//draw all the rectangles to the batch you added in the list
for(Rectangle rect: myList){
  batch.draw(rect,rect.x,rect.y,rect.w,rect.h);
}