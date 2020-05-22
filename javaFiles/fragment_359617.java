// Initially, the mask should have an alpha of 1
Pixmap mask = new Pixmap(128, 128, Pixmap.Format.Alpha);

// Cut a rectangle of alpha value 0
mask.setBlending(Pixmap.Blending.None);
mask.setColor(new Color(0f, 0f, 0f, 0f));
mask.fillRectangle(0, 0, 32, 32);

Pixmap fg = new Pixmap(Gdx.files.internal("foreground.png"));
fg.drawPixmap(mask, fg.getWidth(), fg.getHeight());
mask.setBlending(Pixmap.Blending.SourceOver);

Texture foreground = new Texture(fg);
Texture background = new Texture("background.png");