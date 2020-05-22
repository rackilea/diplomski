protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

        String brandSelected= request.getParameter("search"); 
        //if you add more options in the form you can get those also

       //query database and get arraylist of instrumentTypes by brand. 
       List<String> instrumentTypes = dao.QueriesDAO.getInstrumentType(brandSelected);


        //set attribute for jsp
        request.setAttribute("instrumentTypes", instrumentTypes);

       //add the name of the jsp file you want to view the attribute you just set
      RequestDispatcher rd = request.getRequestDispatcher("searchview.jsp");
        rd.forward(request, response);


    }

}