...
List pathsChilds = node.getChildren("paths");
if(pathsChilds.size() > 0){
   Element paths = (Element)  pathsChilds.get(0);
   List pathChilds = paths.getChildren("path");
   for (int j=0; j< pathChilds.size(); j++) {
      Element path = (Element) pathChilds.get(j);
      out.write("Path: \n"  + path.getText() + "\n\n");
   }
}