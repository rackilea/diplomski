NodesList subs = child.item(j).getChildNodes();

System.out.println(subs.item(0).getTextContent()); // >> Something

Element element = (Element) document.adoptNode(subs.item(0));
System.out.println(element.getAttribute("attribute"));  // >> value