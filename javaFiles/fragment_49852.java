public void printSelectedValues() {
     // getSelectedValueList() replaces getSelectedValues() starting with JDK 1.7
     for(String s : eoList.getSelectedValueList()) {
         System.out.println(s);
     }
 }