Enumeration names=request.getHeaderNames();

  while(names.hasMoreElements())
     {
     String key=names.nextElement().toString();
     String value=request.getHeader(key);
     }