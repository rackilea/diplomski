<%
        Cookie cookie2 = null;
        Cookie[] cookies2 = null;
        // Get an array of Cookies associated with this domain
        cookies2 = request.getCookies();
        if( cookies2 != null ){
           out.println("<h2> Found Cookies Name and Value</h2>");
           for (int i = 0; i < cookies.length; i++){ //Here cookies may be null
              cookie2 = cookies2[i];
              out.print("Name : " + cookie2.getName( ) + ",  ");
              out.print("Value: " + cookie2.getValue( )+" <br/>");
           }
       }else{
           out.println("<h2>No cookies founds</h2>");
       }
        %>