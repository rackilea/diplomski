NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("value");
  Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
  if (fstNmElmnt.hasChildNodes()) {
      NodeList fstNm = fstNmElmnt.getChildNodes();
      System.out.println("Value:  "  + ((Node) fstNm.item(0)).getNodeValue());
  } else {
      System.out.println("Value: null");
  }