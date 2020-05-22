try {
            User responsableMerged = session.merge(responsable);
            transaction = session.beginTransaction();           
            en = new Enquete( titre, dateCreation, dateFermeture, 
                 cloture, collectes, formulaire,responsableMerged );
            session.save(en);
            transaction.commit();   
        }