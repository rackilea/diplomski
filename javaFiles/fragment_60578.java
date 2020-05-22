public static void main( String[] args ) {

        setupInitialContext();

        Context initContext = new InitialContext();        
        DataSource dataSource = (DataSource) initContext.lookup("jdbc/SomeDB");

}