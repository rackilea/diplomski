protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    ArrayList myArray = new ArrayList();  
    myArray.add("array 1");  
    myArray.add("array 2");  
    myArray.add("array 3");  
    request.setAttribute("myArray", myArray);  

    //then call jsp :   
    RequestDispatcher rd = request.getRequestDispatcher("mypage.jsp");  
    rd.forward(request, response);  

}