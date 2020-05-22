import java.io.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import java.util.regex.Pattern; 
import java.util.regex.Matcher;

public class XSSFWrongXMLinSharedStrings {

 static String replaceUTF16SurrogatePairs(String string) {
  Pattern pattern = Pattern.compile("&#(\\d{5});&#(\\d{5});");
  Matcher matcher = pattern.matcher(string);
  while (matcher.find()) {
   String found = matcher.group();
   int h = Integer.valueOf(matcher.group(1));
   int l = Integer.valueOf(matcher.group(2));
   if (0xD800 <= h && h < 0xDC00 && 0xDC00 <= l && l < 0xDFFF) {
    int n = (h - 0xD800) * 0x400 + (l - 0xDC00) + 0x10000;
System.out.print(found + " will be replaced with ");
System.out.println("&#" + n + ";");
    string = string.replace(found, "&#" + n + ";");
   }
  }
  pattern = Pattern.compile("&#(\\d{5});");
  matcher = pattern.matcher(string);
  while (matcher.find()) {
   String found = matcher.group();
   int n = Integer.valueOf(matcher.group(1));
   if (0xD800 <= n && n < 0xDFFF) {
System.out.println(found + " is single part of supplement pair. It will be removed.");
    string = string.replace(found, "");
   }
  }  
  return string;
 }

 public static void main(String[] args) throws Exception {
  File file = new File("ticket.xlsx");

  //Repairing the /xl/sharedStrings.xml on string level. Parsing XML is not possible because of the UTF-16-surrogate-pair XML numeric character references.
  OPCPackage opcPackage = OPCPackage.open(file);
  PackagePart packagePart = opcPackage.getPartsByName(Pattern.compile("/xl/sharedStrings.xml")).get(0);
  ByteArrayOutputStream sharedStringsBytes = new ByteArrayOutputStream();
  byte[] buffer = new byte[1024];
  int length;
  InputStream inputStream = packagePart.getInputStream();
  while ((length = inputStream.read(buffer)) != -1) {
   sharedStringsBytes.write(buffer, 0, length);
  }
  inputStream.close();
  String sharedStrings = sharedStringsBytes.toString("UTF-8");

  //Replace UTF-16-surrogate-pair XML numeric character reference with it's unicode replacement:
  //sharedStrings = sharedStrings.replace("&#55357;&#56833;", "&#x1F601;");
  //ToDo: Create method for replacing all possible UTF-16-surrogate-pair XML numeric character references with their unicode replacements.
  sharedStrings = replaceUTF16SurrogatePairs(sharedStrings);

  OutputStream outputStream = packagePart.getOutputStream();
  outputStream.write(sharedStrings.getBytes("UTF-8"));
  outputStream.flush();
  outputStream.close();
  opcPackage.close();
  //Now the /xl/sharedStrings.xml in the file does not contain UTF-16-surrogate-pair XML numeric character references any more.

  Workbook workbook = new XSSFWorkbook(file); 
  Sheet sheet = workbook.getSheetAt(0);  
  System.out.println("Success.");
 }
}