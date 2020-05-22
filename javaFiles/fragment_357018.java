String excelpath1 = null;
for (int index = 0; index < nodeList.getLength(); index++) {
     System.out.println(nodeList.item(index).getTextContent());
      excelpath1 = nodeList.item(index).getTextContent();
    }
System.out.println("excelpath1 is " + excelpath1);