@Override
    //in caso l'utente voglia uscire
    public void onBackPressed() {
        backpress = (backpress + 1);
        // se preme una volta compare il toast
        if (backpress >= 1 && backpress < 2)
            Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
        //se preme per più di una volta esce
        if (backpress > 1) {
            try {
                //se i giocatori sono più di due, setto i giocatori ad 1 e Correct End a false
                if(ct.getNumberOfPlayers()>=2){
                    ct.setNumberOfPlayers(ct.getNumberOfPlayers()-1);
                    ct.setCorrect_end(false);
                    //aggiorno poi le tabelle
                    Room.child(ct.getId()).setValue(ct);
                    Accounts.child(uID).child("match_found").setValue(false);
                }
                else
                    //se il giocatore è da solo
                if(ct.getNumberOfPlayers()<2)
                {
                    //cancello il figlio dalla tabella matchmaking
                    Room.child(ct.getId()).removeValue();
                    Accounts.child(uID).child("match_found").setValue(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //se poi la partita era già cominciata, cancello il timer per evitare errori
            if(roomcreated)
            timer1.cancel();
            //chiudo l'activity
            this.finish();
        }
    }