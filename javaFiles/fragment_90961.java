public ArrayList<Monster> createMonsters(int count, int maxlevel,
        int minlevel, MonsterTypes type) {
    ArrayList<Monster> monsters = new ArrayList<Monster>();
    // just one texture but multiple sprites
    // save memory :)
    Texture monster = getTextureByType(type);
    for (int i = 0; i < count; i++) {
        // create random level inside the area
        int level = (int) ((Math.random() * maxlevel) + minlevel);
        // create a default monster
        Monster mon = new Monster(level, new Sprite(monster), screen,
                new RandomAI());
        monsters.add(mon);
    }
    return monsters;
}

private Texture getTextureByType(MonsterTypes typ) {
    return this.screen.game.manager.get("monster/" + typ.getFileName()
            + ".png");
}