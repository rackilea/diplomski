Skin skin = new Skin();
skin.add(
        "background",
        new NinePatch(this.game.manager.get("hud/ninepatchframe.png",
                Texture.class), 5, 5, 5, 5));
skin.add("cursor", this.game.manager.get("data/cursor.png"));

TextFieldStyle tStyle = new TextFieldStyle();
tStyle.font = getDefaultFont(25); //here i get the font
tStyle.fontColor = Color.BLACK;
tStyle.background = skin.getDrawable("background");
tStyle.cursor = skin.newDrawable("cursor", Color.GREEN);
tStyle.cursor.setMinWidth(2f);
tStyle.selection = skin.newDrawable("background", 0.5f, 0.5f, 0.5f,
        0.5f);

this.nameField = new TextField("enter name here", tStyle);