public static Nominee winner(Nominee[] all){
    Nominee most = all[0];

    for (int i = 1; i < all.length - 1; i++){
        if (all[i].totalVotes() > most.totalVotes()){
            most = all[i];
        }else if (all[i].totalVotes() == most.totalVotes()){
            String newName = all[i].toString() + " " + most.toString();
            most = new Nominee(newName, (all[i].totalVotes() + most.totalVotes()));
        }
    }

    return most;
}