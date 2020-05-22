HttpServletRequest httpRequest = (HttpServletRequest) request;        
       if(httpRequest.getMethod().equalsIgnoreCase("POST")){
           System.out.println("This is a POST request");
       } else if (httpRequest.getMethod().equalsIgnoreCase("GET")) {
           System.out.println("This is a GET request");
       }