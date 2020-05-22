String query = "CREATE TABLE IF NOT EXISTS survey (uuid_Survey VARCHAR(36) NOT NULL,"+
        "top VARCHAR(40), " +
        " likert VARCHAR(40), "+
        " numerical VARCHAR(40), "+
        " open VARCHAR(40), " +
        " KEY ix_survey_uuid (uuid_Survey), "+
        " PRIMARY KEY (uuid_Survey))";
PreparedStatement statement = conn.prepareStatement(query);
int count = statement.executeUpdate();
if(count>=0){
    System.out.println("Successfully created.");
}