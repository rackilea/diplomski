private View.OnClickListener backtomainmenu = new View.OnClickListener() {
    @Override
    public void onClick(final View view) {
        try {
            if(ct.getNumberOfPlayers()==2){
            ct.setNumberOfPlayers(ct.getNumberOfPlayers()-1);
            Room.child(ct.getId()).setValue(ct);
            Accounts.child(uID).child("match_found").setValue(false);
            }
            else
                if (ct.getNumberOfPlayers()==1 && ct.getStart()&& ct.getCorrect_end()){
                    Room.child(ct.getId()).removeValue();
                    Accounts.child(uID).child("match_found").setValue(false); }
                    else
                        if(ct.getNumberOfPlayers()==1 && ct.getStart() && !ct.getCorrect_end()){
                            Room.child(ct.getId()).removeValue();
                            Accounts.child(uID).child("match_found").setValue(false);}
                            else
                                if(ct.getNumberOfPlayers()==1 && !ct.getStart() && !ct.getCorrect_end()) {
                                    Room.child(ct.getId()).removeValue();
                                    Accounts.child(uID).child("match_found").setValue(false);}


        } catch (Exception e) {
            e.printStackTrace();
        }

        finish();

    }
};