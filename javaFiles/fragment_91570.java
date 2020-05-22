import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import org.apache.poi.hwpf.sprm.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HWPFInspectBgColor {

 private static void showCharacterRunInternals(CharacterRun run) throws Exception {
  Field _chpx = CharacterRun.class.getDeclaredField("_chpx"); 
  _chpx.setAccessible(true);
  SprmBuffer sprmBuffer = (SprmBuffer) _chpx.get(run);
  for (SprmIterator sprmIterator = sprmBuffer.iterator(); sprmIterator.hasNext(); ) {
   SprmOperation sprmOperation = sprmIterator.next();
System.out.println(sprmOperation);
  }
 }

 static SprmOperation getCharacterRunShading(CharacterRun run) throws Exception {
  SprmOperation shd80Operation = null;
  Field _chpx = CharacterRun.class.getDeclaredField("_chpx"); 
  _chpx.setAccessible(true);
  Field _value = SprmOperation.class.getDeclaredField("_value"); 
  _value.setAccessible(true);
  SprmBuffer sprmBuffer = (SprmBuffer) _chpx.get(run);
  for (SprmIterator sprmIterator = sprmBuffer.iterator(); sprmIterator.hasNext(); ) {
   SprmOperation sprmOperation = sprmIterator.next();
   short sprmValue = (short)_value.get(sprmOperation);
   if (sprmValue == (short)0x4866) { // we have a Shd80 structure, see https://msdn.microsoft.com/en-us/library/dd947480(v=office.12).aspx
    shd80Operation = sprmOperation;
   }
  }
  return shd80Operation;
 }

 public static void main(String[] args) throws Exception {
  HWPFDocument document = new HWPFDocument(new FileInputStream("sample.doc"));
  Range range = document.getRange();
  for (int p = 0; p < range.numParagraphs(); p++) {
   Paragraph paragraph = range.getParagraph(p);
System.out.println(paragraph);
   if (!paragraph.getShading().isEmpty()) {
System.out.println("Paragraph's shading: " + paragraph.getShading());
   }

   for (int r = 0; r < paragraph.numCharacterRuns(); r++) {
    CharacterRun run = paragraph.getCharacterRun(r);
System.out.println(run);
    if (run.isHighlighted()) {
System.out.println("Run's highlighted color: " + run.getHighlightedColor());
    }
    if (getCharacterRunShading(run) != null) {
System.out.println("Run's Shd80 structure: " + getCharacterRunShading(run));
    }
   }
  }
 }
}