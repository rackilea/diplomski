private Sprite sprGuy;
private Sprite sprBoss;

sprGuy  = atlas.createSprite("guy");
sprBoss  = atlas.createSprite("boss");

SpriteAux a = new SpriteAux(sprGuy, "guy");
SpriteAux b = new SpriteAux(sprGuy, "guy");
SpriteAux c = new SpriteAux(sprBoss, "boss");

if (a.name.equals(b.name)) {                  //This is true!
    System.out.println("a is equal to b");
}

if (a.name.equals(c.name)) {                  //This is false!
    System.out.println("a is equal to c");
}