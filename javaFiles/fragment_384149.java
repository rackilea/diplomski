StringBuilder sb = new StringBuilder();

for (JCheckBox checkBox : checkBoxes) {
  if (checkBox.isSelected()) {

      String strRaw = new String(checkBox.getText());
      String strRef = new String();

      sb.append("[TifSource]");
      if (strRaw.equals("Site1")){
          sb.append("source=NetworkPath1, ");
      }
      else if (strRaw.equals("Site2")){
          sb.append("source=NetworkPath2, ");
      }
      else if (strRaw.equal("Site3")){
         sb.append("source=NetworkPath3, ");
      }
      sb.append(strRef + "\n");
      sb.append("[Division]");
     sb.append("division=divisionarea\n");
      sb.append("[Area]");
      sb.append("area=6\n");
      sb.append("[TifIndex]");
      sb.append("Updated=0");
      sb.append("Version=81008");
  }
}

try {

   PrintWriter writer = new PrintWriter("C:\\Control\\test1.ini", "UTF-8");
   writer.println(sb.toString());

} catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
   e.printStackTrace();
} catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
   e.printStackTrace();
}