//Load The Level******************************
    //Create a new room
    room = new Room(800,600, 0);
    //Load game objects
    SpaceShip user = new SpaceShip();
    **//Load sprites
    for(int i=0;i<room.numberOfGameObjects;i++) {
        room.gameObjects[i].spriteGLIndex = room.gameObjects[i].loadSprite(context, room.gameObjects[i].spriteResId);   
    }
    //Add them to the room
    room.addGameObject(user);**
    //********************************************