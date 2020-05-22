public <T extends Sprite> ArrayList<T> findAllSpritesOfType(Class<T> clazz) {
    ArrayList<T> sprites = new ArrayList<>();
    for(Sprite s : this.getSprites()) {
        if(clazz.isInstance(s)) {
            sprites.add((T) s);
        }
    }
    return sprites;
}