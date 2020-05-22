public ModelAndView searchAssets(HttpRequest request) {
    StringBuilder builder = new StringBuilder();
    for (String param : request.getParameterNames()) {
        value = request.getParameter(param);
        builder.append(param);
        builder.append("="); // or LIKE
        builder.append("\'" + value "\'");
        builder.append(" AND ");
    }
    // deleting the last " AND "
    builder.delete(builder.length-5, builder.length);
    // In the entity create a method that executes a query with the string
    // If the parameter names are column names then you'd have to use a nativeQuery
    // You'd have to look it up in JPA
   List<Asset> list = Asset.search(builder.toString());
   // put the list in the ModelAndView
}