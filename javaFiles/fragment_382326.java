NodeList hintElmntLst = fstElmnt.getElementsByTagName("hint");
  if (hintElmntLst.getLength() > 0) {
      Element hintElmnt = (Element) hintElmntLst.item(0);
      NodeList hint = hintElmnt.getChildNodes();
      System.out.println("Hint: " + ((Node) hint.item(0)).getNodeValue());
  }