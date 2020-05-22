public void startConnection() {
        try {

            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

        } catch (Exception e) {
            //An exception occurs here, but you don't do anything about it
        }
    }