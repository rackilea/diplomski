private static String clef = null;

public static void choice(Scanner in){

    switch(getNumber(in)){
        case 1:
            clef = saisirClef(in);
            showMenu(in);
            break;
        case 2:
            if(clef == null || clef.isEmpty()){
                System.out.println("Erreur : Aucune clef n’a été saisie.");
                clef = saisirClef(in);
            }
            else{
                afficherClef(clef);
            }
            break;
                    // ...
    }