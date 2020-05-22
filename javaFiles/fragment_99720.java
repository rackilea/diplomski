public void searchFile(SimpleFile targetFile , String searchStr) {
     // SimpleFile generalized behavior.
     if (targetPage instanceof HtmlFile) searchFile((HtmlFile)targetFile, searchStr);
     else if (targetPage instanceof TextFile) searchFile((TextFile)targetFile, searchStr);
     else if (targetPage instanceof XmlFile) searchFile((XmlFile)targetFile, searchStr);
     else if (targetPage instanceof ShellScriptFile) searchFile((ShellScriptFile)targetFile, searchStr);
     else System.out.println("Subtype not recognised"); 
}
public void searchFile(HtmlFile targetFile , String searchStr) {
    // HtmlFile specific behavior
}
public void searchFile(TextFile targetFile , String searchStr) {
    // TextFile specific behavior
}
public void searchFile(XmlFile targetFile , String searchStr) {
    // XmlFile specific behavior
}
public void searchFile(ShellScriptFile targetFile , String searchStr) {
    // ShellScript specific behavior
}