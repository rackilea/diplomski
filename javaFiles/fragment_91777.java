private List<PaintableEntity> entities;
//...
entities = new ArrayList<>(10);
try {
    BufferedImage sheet = ImageIO.read(new File("..."));
    SpriteSheet spriteSheet = new SpriteSheetBuilder().
            withSheet(sheet).
            withColumns(5).
            withRows(4).
            withSpriteCount(19).
            build();

    for (int index = 0; index < 10; index++) {
         entities.add(new AstroidEntity(spriteSheet));
    }

} catch (IOException ex) {
    ex.printStackTrace();
}