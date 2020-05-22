String name = request.getParameter("Name");
if (name != null && name.length() > 0) {
    rs = statement.executeQuery("SELECT * FROM students WHERE Name = '" + name + "'");
} else {
    rs = statement.executeQuery("SELECT * FROM students");
}