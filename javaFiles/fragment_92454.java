Map rssCache;

public void doGet(HttpServletRequest request, HttpServletResponse response) {

    //Map is initialized in the init() method or somewhere else    
    String roomId = request.getParameter("roomid");

    String rssDocument = rssCache.get(roomId);
    if (rssDocument == null) {

        //build the objects you need for the RSS response
        Room room = getRoom(roomId);
        //loadData();
        //moreMethodCalls();
        rssDocument = createRssContent(...);
        rssCache.put(roomId, rssDocument);
    }
    out.println( rssDocument );
}