while (rs.next()) {
    id = rs.getString("userid");

    if (userid.equalsIgnoreCase(id)) {
        status = true;
    } 
    else
    {
        status=false;
    }
}