String type = request.getParameter("type");
String description = request.getParameter("description");
String city = request.getParameter("city");
String location = request.getParameter("location");
String date = request.getParameter("date");
String time = request.getParameter("time");

// Check all the parameters for potential SQL injection attack here

StringBuilder sql = new StringBuilder("Select * from activities where 1 = 1");
if(type != null && type.trim().length() != 0)
    sql.append(" and type = '").append(type).append("'");
if(description != null && description.trim().length() != 0)
    sql.append(" and description = '").append(description).append("'");
if(city != null && city.trim().length() != 0)
    sql.append(" and city = '").append(city).append("'");
if(location != null && location.trim().length() != 0)
    sql.append(" and location = '").append(location).append("'");
if(date != null && date.trim().length() != 0)
    sql.append(" and date = '").append(date).append("'");
if(time != null && time.trim().length() != 0)
    sql.append(" and time= '").append(time).append("'");

Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql.toString());