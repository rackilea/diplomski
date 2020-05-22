NodeList nList = document.getElementsByTagName("part");
// System.out.println("size"+nList.getLength());
for (int temp = 0; temp < nList.getLength(); temp++)
{
   Element eElement = (Element) nList.item(temp);    

   // System.out.println(eElement.getElementsByTagName("number").item(0).getTextContent());

   abbom = new abBOM();
   abbom.setNumber(eElement.getAttribute("number"));
   abbom.setfindNumber(eElement.getAttribute("fnum"));
   abbom.setQty(eElement.getAttribute("qty"));
   abbom.setUom(eElement.getAttribute("uom"));

   list.add(abbom);

   NodeList list2 = eElement.getElementsByTagName("l2part");
   for (int t2 = 0; t2 < list2.getLength(); t2++)
   {
      eElement = (Element) list2.item(t2);
      abBOM abbom2 = new abBOM();
      abbom2.setNumber(eElement.getAttribute("number"));
      abbom2.setfindNumber(eElement.getAttribute("fnum"));
      abbom2.setQty(eElement.getAttribute("qty"));
      abbom2.setUom(eElement.getAttribute("uom"));
      list.add(abbom2);
   }
}