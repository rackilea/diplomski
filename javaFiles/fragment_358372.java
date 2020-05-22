NodeList books = e.getElementsByTagName("book");
NodeList cd = e.getElementsByTagName("cd");
System.out.println(books.getLength());
System.out.println(cd.getLength());

double listPrice = 0;
for(int i=0;i<books.getLength();i++) {
 Node t = books.item(i);
 Element e1 = (Element)t;

 /**This can be reduced if we loop from nList.getLength()-1 to 0, Since the data already exists in data.
 //if (!data.containsKey(e1.getAttribute("name"))){
 //    data.put(e1.getAttribute("name"),Double.parseDouble(e1.getAttribute("price")));
 //
 //}
 */


 listPrice += Double.parseDouble(e1.getAttribute("price"));
}

for(int i=0;i<cd.getLength();i++){
 Node t = cd.item(i);
 Element e1 = (Element)t;
 listPrice += Double.parseDouble(e1.getAttribute("price"));
}