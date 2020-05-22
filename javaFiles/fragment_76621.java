while(rs.next()){ 
        Products prod=new Products();
          prod.setProductname(rs.getString("product_pck"));
          pdt.add(prod);           
}
request.setAttribute("list",pdt);

RequestDispatcher rd=request.getRequestDispatcher("Productlist.jsp");    
rd.forward(request,response);