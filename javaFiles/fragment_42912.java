public static void main(String[] args) throws Exception {
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch(ClassNotFoundException e) {
        //do some exception handling
    }
}