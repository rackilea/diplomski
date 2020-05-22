static{
    try {
        Class.forName ("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}