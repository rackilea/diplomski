public void doGet(HttpServletRequest request, HttpServletResponse response) {
    //build the objects you need for the RSS response
    Room room = getRoom(request.getParameter("roomid"));
    //loadData();
    //moreMethodCalls();
    out.println( createRssContent(...) );
}