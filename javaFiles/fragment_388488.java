ServletContext ctx = request.getServletContext();
ctx.setAttribute("map", Collections.singletonMap(7, "Seven"));

//And later...

Map<Integer, String> map = (Map<Integer, String>) ctx.getAttribute("map");
String value = map.get(7);    //"Seven"