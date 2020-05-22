protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    MyObject pojo = new MyObject();
    pojo.setField1(request.getParameter("field1"));
    pojo.setField2(request.getParameter("field2"));
    pojo.setField3(request.getParameter("field3"));
    /*  Now your object contains the data from the ajax post.
     *  This assumes that all the fields of your Java class are Strings.
     *  If they aren't, you'll need to convert what you pass to the setter.
     */ 
}