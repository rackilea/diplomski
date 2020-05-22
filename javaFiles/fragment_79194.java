Map<String, String> dataMap = new HashMap<>();
    String str = "";                
    for(int i=0; i<sizearray.length; i++) {
        str += sizearray[i];                         
        dataMap.put("data"+i, str.substring(str.lastIndexOf("-") + 1));       
    }    
    request.setAttribute("ssize", dataMap);
    out.println(request.getAttribute("ssize")); // this will now give you all values.