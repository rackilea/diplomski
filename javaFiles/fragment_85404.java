persistenceMap.put("javax.persistence.jdbc.url","jdbc:mysql://localhost:3306/test_db");
persistenceMap.put("javax.persistence.jdbc.user", "root");
persistenceMap.put("javax.persistence.jdbc.password", "root");
persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
persistenceMap.put("hibernate.show_sql", "true");
persistenceMap.put("hibernate.format_sql", "true");
persistenceMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
persistenceMap.put("hibernate.hbm2ddl.auto", "validate");

persistenceMap.put("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
persistenceMap.put("hibernate.c3p0.min_size", "1");
persistenceMap.put("hibernate.c3p0.max_size", "20");
persistenceMap.put("hibernate.c3p0.timeout", "10");
persistenceMap.put("hibernate.c3p0.max_statements", "50");