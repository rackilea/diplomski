import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
/*
To
org.openxmlformats.schemas.wordprocessingml.x2006.main.STHeightRule;
the fully ooxml-schemas-1.3.jar is needed as mentioned in https://poi.apache.org/faq.html#faq-N10025
*/

public class CreateTable 
{
   public static void main(String[] args)throws Exception 
   {
   //Blank Document
   XWPFDocument document= new XWPFDocument();

   //Write the Document in file system
   FileOutputStream out = new FileOutputStream(
   new File("create_table.docx"));

   //create table
   XWPFTable table = document.createTable();
   //create first row
   XWPFTableRow tableRowOne = table.getRow(0);
   tableRowOne.getCell(0).setText("col one, row one");
   tableRowOne.addNewTableCell().setText("col two, row one");
   tableRowOne.addNewTableCell().setText("col three, row one");
   //create second row
   XWPFTableRow tableRowTwo = table.createRow();
   tableRowTwo.getCell(0).setText("col one, row two");
   tableRowTwo.getCell(1).setText("col two, row two");
   tableRowTwo.getCell(2).setText("col three, row two");

int twipsPerInch =  1440;
tableRowTwo.setHeight((int)(twipsPerInch*1/10)); //set height 1/10 inch.
tableRowTwo.getCtRow().getTrPr().getTrHeightArray(0).setHRule(STHeightRule.EXACT); //set w:hRule="exact"

   //create third row
   XWPFTableRow tableRowThree = table.createRow();
   tableRowThree.getCell(0).setText("col one, row three");
   tableRowThree.getCell(1).setText("col two, row three");
   tableRowThree.getCell(2).setText("col three, row three");

twipsPerInch =  1440;
tableRowThree.setHeight(twipsPerInch*1); //set height 1 inch.

   document.write(out);
   out.close();
   System.out.println("create_table.docx written successully");
   }
}