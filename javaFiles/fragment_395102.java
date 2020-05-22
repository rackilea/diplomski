PrintWriter out = response.getWriter(); 
   while (books.next()) {
        String s1 = rs.getString("field1");
        out.write("<b> "+s1+ "</b><br/>");
        String s2 = books.getString("field12");
        out.write("<b> "+s2+ "</b><br/>");
    }