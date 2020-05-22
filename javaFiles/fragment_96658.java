<% 
  String path = request.getServletContext().getRealPath("/stopwords.txt") ;
  //check here with print path variable...    
  // you can pass this path variable to invoke method which is reside into //your java class...
  BufferedReader br = new BufferedReader(new FileReader(path));


%>