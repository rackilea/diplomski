public static String comment(int score, int parForHole) {
    int total = parForHole - score;

    switch(total) {

        case 3 :
            return "albatross!!!";


        //   ... and so on


    }

    if (total > 4)
        return "condor!!!!";
    if (total <= 3)
       return "triple+ bogey!!!!";

    return "asdasd";
}