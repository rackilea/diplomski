Matchmaking.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            //prendo tutte le tabelle e le aggiungo a list_party
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ct = ds.getValue(Class_party.class);
                    List_party.add(ct);
                }
                // mi prendo la partita che mi interessa
                for (int i = 0; i < List_party.size(); i++) {
                    if (List_party.get(i).getId() == intent_id) {
                        ct = List_party.get(i);
                    }
                }
                //controllo che gli utenti collegati siano due e che la partita non sia cominciata ne finita in modo anomalo
            if (ct.getNumberOfPlayers() == 2 && !ct.getAccessible() && ct.getCorrect_end() && !ct.getStart()) {
                    //mi scarico le bandiere che sono state scelte alla creazione della ROOM
                FlagsFromDB = ct.getFlag();
                //passo dal Layout di Waiting a quello iniziale
                switchToScreen(R.id.screen_intro);
                matchFound=true;
                Toast.makeText(MpMultiplayer.this, "Match Found", Toast.LENGTH_SHORT).show();
                //imposto il match trovato = true
                currentwithID.setMatch_found(true);
                //aggiorno la tabella
                Accounts.child(uID).setValue(currentwithID);
            }
            //se la partita è cominciata e il numero di giocatori è uguale a due e match_found = true
            if (ct.getStart() && ct.getNumberOfPlayers()==2 && matchFound) {
                    //dico che la room è stata creata
                roomcreated = true;
                //ora il gioco comincia e cambio di layout
                switchToScreen(R.id.screen_game);
                Popolate();
            }
            //se qualcuno esce prima del previsto e la partita è già cominciata
            if(!ct.getCorrect_end() && roomcreated)
            {
                //assegno automaticamente all'utente 500 punti
                points += 500;
                timer1.cancel();
                mName.setText(intent_user + " You Won!");
                mName.setTextSize(25);
                mPoints.setText(new Integer(points).toString());
                switchToScreen(R.id.screen_score);
                Toast.makeText(MpMultiplayer.this, "The player LEFT the game", Toast.LENGTH_SHORT).show();
            }
            //se l'utente si è scollegato e la partita non è ancora cominciata
            if(!ct.getCorrect_end() && !roomcreated)
            {  //assegno automaticamente 100 punti
                points += 100;
                mName.setText(intent_user + "You Won!");
                mName.setTextSize(25);
                mPoints.setText(new Integer(points).toString());
                switchToScreen(R.id.screen_score);
                Toast.makeText(MpMultiplayer.this, "The player LEFT the game", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    });