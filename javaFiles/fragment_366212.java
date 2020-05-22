try {
        String insertTableSQL = "INSERT INTO DBUSER"+ "fcltyName,CommunicationOral,Communicationwritten,Leadership,AnalyticalAbilities,Interpersonalskills,DecisionMakingSkills,SelfConfidence,Creativity,Punctualityregularity,GeneralAwareness,Commitment,HardWork) VALUES"+ "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        dbConnection = getDBConnection();
        preparedStatement = dbConnection.prepareStatement(insertTableSQL);

        preparedStatement.setStringt(1, fcltyName);
        preparedStatement.setInt(2, 0);
        preparedStatement.setInt(3, 0);
        preparedStatement.setInt(4,0);
        preparedStatement.setInt(5, 0);
        preparedStatement.setInt(6, 0);
        preparedStatement.setInt(7,0);
        preparedStatement.setInt(8, 0);
        preparedStatement.setInt(9, 0);
        preparedStatement.setInt(10,0);
        preparedStatement.setInt(11, 0);
        preparedStatement.setInt(12, 0);
        preparedStatement.setInt(13,0);

        // execute insert SQL stetement
        preparedStatement.executeUpdate();}'