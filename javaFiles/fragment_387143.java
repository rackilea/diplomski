// connect to database
    log.info("Connecting to database @ " + dbUrl + " using " + dbUser + "/" + dbPass);
    emf = Persistence.createEntityManagerFactory("manager", Maps.create(
            "javax.persistence.jdbc.user", dbUser,
            "javax.persistence.jdbc.password", dbPass,
            "javax.persistence.jdbc.url", dbUrl
    ));