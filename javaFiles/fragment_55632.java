SpringApplication application = new SpringApplication(IdMatrixApplication.class);
File file = new File("src/main/resources/dev/application-prod.properties");
if (file.exists()) {
    application.setAdditionalProfiles("prod","dev");
}
application.run(args);