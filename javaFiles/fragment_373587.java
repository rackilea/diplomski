double nPages = 0;
while (it.hasNext()) {
    tmp = it.next();
    nPages = ((Document)tmp.get("pages")).getDouble("end") - ((Document)tmp.get("pages")).getDouble("start");
    System.out.println(tmp);
    System.out.println("Number of pages: " + nPages);
 }