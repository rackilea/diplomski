final BitmapFont font = new BitmapFont();

final String text = "Test";

final GlyphLayout layout = new GlyphLayout(font, text);
// or for non final texts: layout.setText(font, text);

final float fontX = objectX + (objectWidth - layout.width) / 2;
final float fontY = objectY + (objectHeight + layout.height) / 2;

font.draw(batch, layout, fontX, fontY);