HttpSession session = request.getSession();
    rs = state.executeQuery(search_sql);  //after executing the query just write these two lines instead of while loop
   HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>(); //change here
ArrayList<String> ls=null; //change here
int i=0;
    while (rs.next()) {
                ls=new ArrayList<String>(); //change here
                ls.add(rs.getString("item_id"));
                ls.add(rs.getString("name"));
                ls.add(rs.getString("unit_price"));
                ls.add(rs.getString("qty"));
                hm.put("row"+(++i), ls);
            }
    session.setAttribute("hm",hm);
    response.sendRedirect("index.jsp"); //redirect to jsp without any params