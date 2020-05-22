ElementFilter filter=new org.jdom2.filter.ElementFilter("not-in-stock");
 Element searchElement=null;
 for(Element c:root.getDescendants(filter))
 {
   searchElement=c;
   break;
 }
 if(searchElement!=null){
     searchElement.setName("NewName");
     searchElement.setText("Something is diff");
     XMLOutputter output=new XMLOutputter();
     output.output(doc, new FileOutputStream(file));
 }