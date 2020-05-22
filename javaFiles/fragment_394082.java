public void doGet( // or doPost
    HttpServletRequest req, 
    HttpServletResponse res
) throws ServletException, IOException  {
    List<Object> myList = new ArrayList<>();
    req.setAttribute("myList", myList);
}