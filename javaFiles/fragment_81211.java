int i = 1;
int answer;
int d;
int e;
boolean alive = true;

System.out.println("\n");

System.out.println(enemies[i].getName() + " has appeared!");

System.out.print("\n");

while (alive == true) {

    System.out.println("Hitpoints[HP]: " + enemies[i].getHP());
    System.out.println("Attack[ATK]  : " + enemies[i].getATK());
    System.out.println("Mana[MANA]   : " + enemies[i].getMANA());

    System.out.println("\n");
    if (user.getP_HP() > 0) {
        System.out.println("[1 - Attack]");
        System.out.println("[2 - Flee]");

        answer = In.getInt();

        System.out.println("\n");
    } else if (user.getP_HP() <= 0) {
            System.out.println(user.getP_Name() + " has been slain by the " + enemies[i].getName() + "!");
            alive = false;
            answer = 0; //so it won't execute the rest of the code
            }

    if (answer == 1) {

        d = enemies[i].getHP() - user.getP_ATK();
        enemies[i].setHP(d);

        System.out.println(user.getP_Name() + " strikes the " + enemies[i].getName() + " for " + user.getP_ATK() + " damage.");
        System.out.println(enemies[i].getName() + " has " + enemies[i].getHP() + " HP remaining.");
        System.out.println("\n");

        if (enemies[i].getHP() > 0) {
            e = user.getP_HP() - enemies[i].getATK();
            user.setP_HP(e);

            System.out.println("The " + enemies[i].getName() + " attacked you for " + enemies[i].getATK() + " damage.");
            System.out.println(user.getP_Name() + " has " + user.getP_HP() + " HP remaining.");
            System.out.println("\n");
        } else if (enemies[1].getHP() <= 0) {
            System.out.println(user.getP_Name() + " has slain the " + enemies[i].getName() + "!");
            alive = false;
        }

    } else if (answer == 2) {
        System.out.println("You try to run, but fall into a pit of spikes and die!");
        alive = false;
    }
}