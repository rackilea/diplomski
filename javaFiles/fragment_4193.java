import org.drools.decisiontable.SpreadsheetCompiler;

String rulesExcel = "C:\\my\\path\\file.xls";
InputStream is = null;
try {
  is= new FileInputStream(rulesExcel);
} catch (FileNotFoundException e) {
        e.printStackTrace();
}
SpreadsheetCompiler sc = new SpreadsheetCompiler();
String rules=sc.compile(is, InputType.XLS);
KieSession kieSession = new KieHelper().addContent(rules, ResourceType.DRL).build().newKieSession();