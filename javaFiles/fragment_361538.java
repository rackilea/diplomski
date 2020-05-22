if(pick >= 1 && pick <= pile/2){
        pile = pile - pick;
        System.out.println(pile + "left.");}
        else {
            System.out.println("Illegal Move.");
            turn = 0;
            continue;
}