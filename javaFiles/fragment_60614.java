public class Project {

/**
 * @param args
 * @param Scanner
 */
public static void main(String[] args) {
    String clef = "vide";
    Scanner in = new Scanner(System.in);

    showMenu(in,clef);// passed clef as a parameter - The New Idiot
    in.close();

}

/**
 * added an extra parameter
 * @param clef
 * @modified The New Idiot
 */
public static void showMenu(Scanner in,String clef) {
    System.out.printf("******************************************%n"
            + "* Choisissez une des options suivantes : *%n"
            + "* 1) Saisir la clef secrète              *%n"
            + "* 2) Afficher la clef secrète            *%n"
            + "* 3) Chiffrer un fichier                 *%n"
            + "* 4) Déchiffrer un fichier               *%n"
            + "* 5) Quitter                             *%n"
            + "******************************************%n%n%n");
    // passed clef as a parameter - The New Idiot
    choice(in,clef);
}

public static int getNumber(Scanner in) {
    int choice = in.nextInt();
    in.nextLine();
    return choice;
}

/**
 * added an extra parameter
 * @param clef
 * @modified The New Idiot
 */
public static void choice(Scanner in,String clef) {

    try {

        switch (getNumber(in)) {
        case 1:
            // removed duplicate variable declaration - @modified The New Idiot
            clef = saisirClef(in);
            resetMenu(clef, in);
            // passed clef as param - @modified The New Idiot
            showMenu(in,clef);
            break;
        case 2:
            //String should be compared with equals() method - @modified The New Idiot
            if (clef.equals("vide")) {
                System.out.println("Erreur : Aucune clef n’a été saisie.");
                // passed clef as param -@modified The New Idiot
                showMenu(in,clef);
            } else {
                System.out.println("La clef secrète est :" + clef);
            }
            break;
        case 3:
            chiffrerFichier();
            break;
        case 4:
            dechiffrerFichier();
            break;
        case 5:
            quitApplication();
            break;
        default:
            System.out.println("Default");
            break;
        }
    } catch (Exception e) {
        System.out.println("Please enter a number");
        // choice(in);
    }
}

/**
 * Commented this method, as it does nothing
 * @return
 * @modified The New Idiot
 */
/*public static String afficherClef() {
    return clef;
}*/

public static boolean isKeyLength(String a) {
    boolean flag = true;
    if (a.length() < 4) {
        System.out.println("Erreur : Le mot est trop petit");
        flag = false;
    }
    return flag;
}

public static String validateKey(String a) {

    // declared a local variable flag
    // it will be true only if sKeyLength(a) and isKeyChar(a) are true
    // @modified The New Idiot
    boolean flag = isKeyLength(a) && isKeyChar(a);

    if (flag) {
        String clef = a;
        System.out.println(clef);
        return clef;
    } else {
        String clef = "showMenu";
        return clef;
    }
}

public static boolean isKeyChar(String a) {
    boolean flag = true;
    for (int i = 0; i <= a.length() - 1; i++) {
        // Verifie Majuscule
        if ((int) a.charAt(i) >= 65 && (int) a.charAt(i) <= 90) {
            System.out.println("Au moins une des lettre est en Majuscule");

            // Continue Program
        } else {
            System.out
                    .println("Erreur : Au moins un caractère est invalide ");
            flag = false;
        }
        // Verifie Doublons
        if (i == a.length() - 1) {
            if (a.charAt(i) == a.charAt(i - 1)) {
                System.out
                        .println("Erreur : Il existe au moins un doublon.");
                System.out.println("Dernier iteration");
                // Restart Program
                flag = false;
            } else {
                // Continue Program
                System.out.println("No doubles found");
                System.out.println("Dernier iteration");
            }
        } else {
            if (a.charAt(i) == a.charAt(i + 1)) {
                System.out
                        .println("Erreur : Il existe au moins un doublon.");
                System.out.println("Iteration :" + i);
                // Restart Program
                flag = false;
            } else {
                // Continue Program
                System.out.println("No doubles found");
            }
        }
    }
    return flag;
}

public static String saisirClef(Scanner in) {
    System.out.println("Saisir la clef secrète  :");
    String a = in.nextLine();
    System.out.println("Voici ce que vous avez tapper : " + a);
    return validateKey(a);
}

public static void resetMenu(String clef, Scanner in) {
    if (clef == "showMenu") {

        saisirClef(in);
    } else {
        System.out.println("Clef saisie avec succes");
    }
}

public static void chiffrerFichier() {
    System.out.println("Chiffrer un fichier :");
}

public static void dechiffrerFichier() {
    System.out.println("Déchiffrer un fichier :");
}

public static void quitApplication() {
    System.out.println("Quitter :");
}

}