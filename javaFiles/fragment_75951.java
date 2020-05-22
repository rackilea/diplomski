Map link = new LinkedHashMap();
    link.put("key", "value");
    //put map as request attribute 
    request.setAttribute("hash",link);
    //get map as request attribute from the request
    Map link1 =(Map)request.getAttribute("hash");