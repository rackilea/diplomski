PreparedStatement ps = cnx.prepareStatement("SELECT Client.Nom , 
Facture.Date_Achat , Client.Prénom , Facture.N°Fac , SUM(Contient1.Quantité1*PrixAchatMonture)AS Somme "+ 
"FROM Facture , Client , Contient1 , Monture "+
"ON Facture.N°Client=Client.N°Client AND Facture.N°Fac=Contient1.N°Fac AND Contient1.IDM=Monture.IDM "+
"WHERE Client.Nom =? AND Client.Prénom=? "+
"GROUP BY Client.Nom, Facture.Date_Achat, Client.Prénom, Facture.N°Fac",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        // ! au sens de la jointure pour l'affichage