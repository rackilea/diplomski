<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Functions.DBConnections"%>
<%@page import="java.util.List"%>
<%
    String query = request.getParameter("term");
    List<String> CategoryList = new DBConnections().GetCategoryList(query);
    Iterator CatIterator = CategoryList.iterator();
    String JCategory = "";
    Map CategoryMap;
    Gson gson = new Gson();
    List autoComplete = new ArrayList();
    while (CatIterator.hasNext()) {
        String Category = (String) CatIterator.next();
        String CategoryID = (String) CatIterator.next();
        CategoryMap = new HashMap<String,String>();
        CategoryMap.put("Category", Category);
        CategoryMap.put("CategoryID", CategoryID);
        //JCategory = gson.toJson(CategoryMap);
        autoComplete.add(CategoryMap);
    }

    JCategory = gson.toJson(autoComplete);
    System.out.println(JCategory);
    //out.print(JCountry);
    out.print(JCategory);
%>