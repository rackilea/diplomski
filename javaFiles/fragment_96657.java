<%

String path = request.getServletContext().getRealPath("/WebContent/stopwords.txt") ;
BufferedReader br = new BufferedReader(new FileReader(path));
// other codes...
 %>