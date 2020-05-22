public BitmapFont getDefaultFont(int size) {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
            Gdx.files.internal("fonts/font.ttf"));
    defaultFont = generator.generateFont(size + 5); //some offset
    return defaultFont;
}