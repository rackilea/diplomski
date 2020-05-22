try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                    "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES,
                    "org.apache.naming");
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:comp");
            ic.createSubcontext("java:comp/env");

            // Construct DataSource for staging
            // Construct DataSource for wfms
            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setUrl("jdbc:postgresql://localhost:5432/maintenanceDB");//you might get this from context
            ds.setUser("paul");//you might get this from context
            ds.setPassword("1234");//you might get this from context

            ic.bind("java:comp/env/maintenanceDB", wfmsds);

        } catch (NamingException ex) {
            ex.printStackTrace();
        }