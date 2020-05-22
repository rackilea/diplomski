while (rs.next()) {
    Message m = new Message(
    rs.getString("POOLNAME"),// poolname is one of the column
                                        // of table
    rs.getString("DESCRIPTION"));
    data.add(m);

}