public static void setupInitialContext() {
            try {
                NamingManager.setInitialContextFactoryBuilder(new InitialContextFactoryBuilder() {

                    @Override
                    public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
                        return new InitialContextFactory() {

                            @Override
                            public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
                                return new InitialContext() {

                                    private Hashtable<String, DataSource> dataSources = new Hashtable<>();

                                    @Override
                                    public Object lookup(String name) throws NamingException {

                                        if (dataSources.isEmpty()) { //init datasources
                                            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
                                            ds.setURL("jdbc:mysql://localhost:3306/SomeDB");
                                            ds.setUser("dbuser");
                                            ds.setPassword("dbpass");
                                            dataSources.put("jdbc/SomeDataSourceName", ds); 
    //lets add another datasource (optional)
                                            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
                                            ds.setURL("jdbc:mysql://localhost:3306/OtherDB");
                                            ds.setUser("dbuser");
                                            ds.setPassword("dbpass");
                                            dataSources.put("jdbc/OtherDataSourceName", ds);    
//you can keep adding these as you need                                         
                                        }

                                        if (dataSources.containsKey(name)) {
                                            return dataSources.get(name);
                                        }

                                        return null; //or throw exception Java style :)
                                    }
                                };
                            }

                        };
                    }

                });
            }
            catch (NamingException ne) {

            }
        }