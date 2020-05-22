public void ajouter(InfoSecteur infoSecteur) {
    Connection connexion = null;
    PreparedStatement preparedStatement = null;

    try {
        connexion = daoFactory.getConnection();
        //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
        // Ainsi on n'a pas besoin de refaire la connexion systématiquement
        // On récupère la connexion qui a déjà été faite en amont dans la factory
        preparedStatement = connexion.prepareStatement("INSERT INTO sector( name, description, site_id) VALUES(?, ?, ?);");
        preparedStatement.setString(1, infoSecteur.getName());
        preparedStatement.setString(2, infoSecteur.getDescription());
        preparedStatement.setInt(3, infoSecteur.getSite_id());

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public List<InfoSecteur> lister(int ID) {
    List<InfoSecteur> infoSecteurs = new ArrayList<InfoSecteur>();
    Connection connexion = null;
    PreparedStatement ps = null;
    ResultSet resultat = null;


    try {
        connexion = daoFactory.getConnection();
        ps = connexion.prepareStatement("SELECT name, description, site_id, sector_id FROM sector WHERE site_id=?");
        ps.setInt(1, ID);

        resultat = ps.executeQuery();



        // Récupération des données
        // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
        while (resultat.next()) {
            // on récupère les entrées grace à la méthode getString ou getInt qui permettent de récupérer des données de types string ou int
            //resultat.getString => je m'attends à récupérer une chaine de caractère ou un nombre ou une date etc... puis on les tocke dans des objets de type string, int, etc...
            String name = resultat.getString("name");
            String description = resultat.getString("description");
            int site_id = resultat.getInt("site_id");
            int sector_id =resultat.getInt("sector_id");


            // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
            InfoSecteur infoSecteur = new InfoSecteur();
            infoSecteur.setName(name);
            infoSecteur.setDescription(description);
            infoSecteur.setSite_id(site_id);
            infoSecteur.setSector_id(sector_id);

            // on ajoute cet objet à un array (ou liste) grace à la méthode add. on ajout infoSecteur à infoSecteurs
            infoSecteurs.add(infoSecteur);
            // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } return infoSecteurs;

}