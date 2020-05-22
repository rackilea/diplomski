String query = "SELECT pref FROM usermodel  WHERE nomU = ?";

try (PreparedStatement prstm = connection.prepareStatement(query)){

    prstm.setSting(str);//set your input the query

    ResultSet resultat2 = prstm.executeQuery(query2);
    while (resultat2.next()) {
        String pref = (String) resultat2.getString("pref");
        System.out.println("l' element , " + pref + ",est une préférence de l'utilisateur " + str + " .");
    }
}