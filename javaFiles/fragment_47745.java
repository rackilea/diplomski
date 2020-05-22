public void renderMonster(MapObject object) {
    if (object instanceof TextureMapObject) {
        TextureMapObject textureMonster = (TextureMapObject) object;
        textureMonsters.add(textureMonster);
        batch.begin();
        batch.draw(textureMonster.getTextureRegion(), textureMonster.getX(), textureMonster.getY());
        batch.end();
        // move the monster
        textureMonster.setX(randomMove(-1, 1).x + textureMonster.getX());
        textureMonster.setY(randomMove(-1, 1).y + textureMonster.getY());
    }
}