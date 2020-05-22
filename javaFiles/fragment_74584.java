public void create(){
       ....
       world = new World(new Vector2(0,0),false);
       rayHandler = new RayHandler(world);

    }
...
public void dispose(){
      ...
      rayHandler.dispose;
      world.dispose();
}