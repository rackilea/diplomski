//create enemies
Mole enemies[3];
enemies[0] = new Mole();
enemies[1] = new Mole();
enemies[2] = new Mole();

//an enemy dies!
enemies[1] = null;

//and comes back to life!
enemies[1] = new Mole();

//do something with your enemies....