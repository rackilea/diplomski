//Pixmap with one pixel
Pixmap pm1 = new Pixmap(1, 1, Format.RGB565);
pm1.setColor(Color.GREEN);
pm1.fill();

Pixmap pm2 = new Pixmap(1, 1, Format.RGB565);
pm2.setColor(Color.RED);
pm2.fill();

dialogueWindow = getWindow();

dialogueWindow.setTitle("New Game");
// The table that will have the green color 
Table row1 = new Table(mySkin);
row1.add(nameStation);
row1.add(nameStationField);
row1.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(pm1))));
dialogueWindow.add(row1);
dialogueWindow.row();

// The table that will have  the green color
Table row2 = new Table(mySkin);
row2.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(pm2))));
row2.add(cancel).size(120, 60);
row2.add(ok).size(100, 60);

dialogueWindow.add(row2).fillX();
dialogueWindow.row();