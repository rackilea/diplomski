//MATCHMAKING
public void Create(View view)
{
    boolean start = false;
    boolean correct_end = true;
    boolean accessible = true;
    uSer = user.getDisplayName();
    //se la lunghezza delle partite disponibili a cui accedere è ==0
    if(size==0||Id_rooms.size()==0)
    {
        //creo la chiave univoca per il match
        String id = Matchmaking.push().getKey();
        //creo un utente corrente con nome e punteggio
        current=new Class_user(uSer,0);
        //un utente con ID utente, nome e se il match è stato trovato
        //genero le domande che verranno utilizzato solo per quel determinato match
        list_game= Generation();
        //ora creo il match vero e proprio e lo inserisco nella tabella matchmaking
        second = new Class_party(id, current, list_game,start,correct_end,accessible);
        Matchmaking.child(id).setValue(second); }
    else{
        accessible = false;
        // se invece ci sono delle partite disponibili, le randomizzo
        Collections.shuffle(Id_rooms);
        for(int i=0; i<List_party.size();i++)
        {
            //le passo tutte finché non trovo quella con l'ID corrispondente alla prima che ho randomizzato
            if(List_party.get(i).getId()==Id_rooms.get(0))
            {
                // popolo la variabile class_party
                second=new Class_party(List_party.get(i).getId(),List_party.get(i).getUser1(),List_party.get(i).getFlag(),start,correct_end,accessible);
            }
        }
        matchFound = false;
        //inserisco l'utente e il numero di giocatori = 2
        currentwithID = new Class_user(uID,uSer,matchFound);
        current=new Class_user(uSer,0);
        second.setUser2(current);
        second.setNumberOfPlayers(2);
        //ora reinserisco tutto nel figlio che ha come ID, quello della stanza selezionata
        Matchmaking.child(second.getId()).setValue(second);
        Accounts.child(uID).setValue(currentwithID);
    }

}

public ArrayList<Integer> Generation()
{
    ArrayList<Integer> tmp = new ArrayList<>();
    Collections.shuffle(mFlag);
    for(int i=0; i<=10; i++) //3 momentaneamente
    {
        tmp.add(mFlag.get(i));
    }
    Toast.makeText(HomeActivity.this,"Domande generate",Toast.LENGTH_LONG).show();

    return tmp;
}