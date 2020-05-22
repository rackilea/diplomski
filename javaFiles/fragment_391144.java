String name = request.getParameter("name");
String age = request.getParameter("age");
List<String> lang = request.getParameterValues("fav");
if(lang==null) {
    lang = new String[] {""};
}
InsertPost.add(new Post(name, age, lang));
//not recommended as it will add 1-byte of empty string even if there is no fav language