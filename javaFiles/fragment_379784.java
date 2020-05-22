request.setAttribute("muckingwattrs", "Strange");

Enumeration attrs =  request.getAttributeNames();
while(attrs.hasMoreElements()) {
    System.out.println(attrs.nextElement());
}

System.out.println("----------------------------");

Enumeration attrs2 =  request.getAttributeNames();
while(attrs2.hasMoreElements()) {
    System.out.println(attrs2.nextElement());
}