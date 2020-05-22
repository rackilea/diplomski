// route
get("/csv/:path", (req, res) -> {
res.type("text/csv");
    StringBuilder sb = new StringBuilder();
    sb.append("id");
    sb.append(',');
    sb.append("Name");
    sb.append('\n');

    sb.append("1");
    sb.append(',');
    sb.append("Zack");
    sb.append('\n');
    return sb.toString(); 
});