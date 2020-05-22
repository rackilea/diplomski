public class Glyph {
 void draw() {
  System.out.println("Glyph.draw(");
 }
 Glyph() {
  System.out.println("Glyph() before draw()");
  Glyph.draw();//explicit calling
  System.out.println("Glyph() after draw()");
 }
}