protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String searchTerm = request.getParameter("Search");
 ArrayList<Abc> ab= new ArrayList();


try
  {

String sql1 ="select * from products where name like %?%";

PreparedStatement ps = conn.prepareStatement(sql1);

ps.setString(1,searchTerm);

resultSet = ps.executeQuery();
while(resultSet.next())
{

   Abc b=new Abc();
    b.setUser(resultSet.getString("user"));
     ab.add(b);

 }

request.setAttribute("r1", ab);      
request.getRequestDispatcher("productSearch.jsp").forward(request, response);


   }

catch(Exception s2)
{
   s2.printStackTrace();
}

    }
}