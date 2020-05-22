StringBuilder sb_url = new StringBuilder("jdbc:cassandra://")
            .append(this.url)
            .append(":")
            .append(this.port)
            .append("/")
            .append(this.database)
            ;

    Properties props = new Properties();
    props.setProperty("user", this.username);
    props.setProperty("password", this.password);