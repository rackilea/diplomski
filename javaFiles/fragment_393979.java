DELETE FROM facture f 
    WHERE EXISTS (SELECT 1
                  FROM client c 
                  WHERE f.idClient = c.id AND c.nom = ? 
                 )
    ORDER BY f.idFact DESC
    LIMIT 1;