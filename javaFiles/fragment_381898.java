InputStream is = filterConfig.getServletContext()
   .getResourceAsStream("/WEB-INF/web.xml");
 DocumentBuilder builder = DocumentBuilderFactory.newInstance()
   .newDocumentBuilder();
 Document document = builder.parse(is);
 NodeList servlets = document.getElementsByTagName("servlet");