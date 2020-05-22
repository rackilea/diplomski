Pixmap originalPix = new Pixmap(Gdx.files.internal("badlogic.jpg"));  // 256 * 256
Pixmap scaledPix = new Pixmap(700, 700, originalPix.getFormat());
scaledPix.drawPixmap(originalPix, 0, 0, originalPix.getWidth(), originalPix.getHeight(), 0, 0, scaledPix.getWidth(), scaledPix.getHeight());
Texture texture = new Texture(scaledPix);  // 400 * 400
originalPix.dispose();
scaledPix.dispose();