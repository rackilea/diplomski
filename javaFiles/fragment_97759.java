JsonObject jo = new JsonObject();
jo.addProperty("page", page);
jo.addProperty("total", totalPageString);
jo.addProperty("records", count);

JsonArray jArray = new JsonArray();
try {
    while (rs2.next()) {
        JsonObject row = new JsonObject();

        row.addProperty("id", rs2.getString(1));
        row.addProperty("name", rs2.getString(2));
        row.addProperty("author", rs2.getString(3));
        jArray.add(row);
    }
    jo.add("rows", jArray);
} catch (SQLException e) {
    e.printStackTrace();
}

response.setContentType("application/json");
response.getWriter().print(jo);