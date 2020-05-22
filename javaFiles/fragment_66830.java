Create a FileOutputStream
for (each item in the ArrayList){
  get the properties of the PanelFurniture object, and write them to the FileOutputStream.
  eg. fos.writeLine(panelFurniture.getName() + "," + panelFurniture.getValue());
  }
Close the FileOutputStream.