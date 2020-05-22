protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    if(request.getParameter("SQL1")!=null){

    }

    JSONObject result = new JSONObject();
    JSONArray jsonArray = new JSONArray();
    PrintWriter out = response.getWriter();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/mydb", "root", "root");

        PreparedStatement statement = con
                .prepareStatement("SELECT * FROM event");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            JSONObject eventInfo = new JSONObject();
            eventInfo.put("eventID", result.getString("eventID"));
            eventInfo.put("eventName", result.getString("eventName"));
            eventInfo.put("eventDesc", result.getString("eventDesc"));
            eventInfo.put("eventDate", result.getString("eventDate"));
            eventInfo.put("eventTime", result.getString("eventTime"));
            eventInfo.put("eventX", result.getString("eventX"));
            eventInfo.put("eventY", result.getString("eventY"));
            eventInfo.put("eventBy", result.getString("eventBy"));
            jsonArray.put(eventInfo);
        }
        result.put("Events", (Object) jsonArray);
    }

    catch (JSONException je) {
        System.out.println(je.getMessage());
    } catch (Exception exc) {
        System.out.println(exc.getMessage());
    }

    out.println(result.toString());
}