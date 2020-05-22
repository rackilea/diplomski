public void foo() throws Exception {
    Connection connection = getConnection();
    //do what you want/need...

    //in the end, you close the connection
    //this is A MUST!
    connection.close();
}