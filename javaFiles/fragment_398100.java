//metodo per la gestione dei cambiamenti della tabella Matchmaking
        Matchmaking.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //nel caso ci siano delle modifiche alla tabella
                //se il match non è stato trovato e Account è stato verificato
                if(accountFound){
                    //azzero la Lista
                    List_party = new ArrayList<>();
                    Id_rooms = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //sempre se matchfound non è stato trovato
                    if (!currentwithID.getMatch_found()) {
                        //prendo la quantità di figli presenti
                        size = Integer.parseInt(String.valueOf(dataSnapshot.getChildrenCount()));
                        //inserisco all'interno della variabile CT il valore di ogni figlio
                        ct = ds.getValue(Class_party.class);
                        // e se è il numero di giocatori == 1 e la partita non è iniziata e finita in modo anomalo
                        if (ct.getNumberOfPlayers() == 1 && !ct.getStart() && ct.getCorrect_end() && ct.getAccessible()) {
                            //aggiungo l'id della room alla lista
                            //Inserisco alla list_party l'intero oggetto
                            Id_rooms.add(ct.getId());
                            List_party.add(ct);
                        }

                        Toast.makeText(HomeActivity.this, "Lista ROOMs aggiornata", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            }