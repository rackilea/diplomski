class RoundGlyph extends Glyph {
   int radius = 1;
   RoundGlyph(int r) {
    super();
    radius = r;
    System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
  }
@Override
void draw() {
   super.draw();//go draw in parent first
   System.out.println("RoundGlyph.draw(), radius = " + radius);
 }
}