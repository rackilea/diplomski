for (Element tr : elems){
   //^^^^^^^^^^ - element holding single tr
    Elements tds = tr.select("td");
    System.out.println(tds);
    System.out.println("---------");
    System.out.println(tds.size());  
}