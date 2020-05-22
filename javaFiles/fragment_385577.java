InputStream inputFile = this.getClass().getClassLoader().getResourceAsStream("EmailSettings.properties");

Properties emailConfig = new Properties();

emailConfig.load( inputFile );
.
.
.