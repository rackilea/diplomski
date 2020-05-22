public List<Push> getPushfr() {
    String queryPushfr = "SELECT idp,titrefr,contenufr,titreuk,contenuuk,pays,marche,type,datep,isImportant, image FROM push WHERE datep > DATE_SUB(CURRENT_DATE, INTERVAL 3 MONTH) ORDER BY datep DESC;";
    try {
        connexion = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = connexion.prepareStatement(queryPushfr);
        resultat = pstmt.executeQuery(queryPushfr);
        while (resultat.next()) {
            int idp = resultat.getInt("idp");
            String titrefr = resultat.getString("titrefr");
            String contenufr = resultat.getString("contenufr");
            String titreuk = resultat.getString("titreuk");
            String contenuuk = resultat.getString("contenuuk");
            String pays = resultat.getString("pays");
            String marche = resultat.getString("marche");
            String type = resultat.getString("type");
            Date datep = resultat.getTimestamp("datep");
            int isImportant = resultat.getInt("isImportant");
            String image = resultat.getString("image");
            this.pushfr.add(
                    new Push(idp, titrefr, contenufr, titreuk, contenuuk, pays, marche, type, datep, isImportant,image));
        }
    } catch (Exception ex) {
        System.err.println(ex.getMessage());
    }
    return pushfr;
}