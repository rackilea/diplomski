int food = 0;
int foodperson = 0;
int energy = 0;
int hulltotal = 0;
int hullhealth = 0;
int enemy1basehealth = 0;
int enemy1basedamage = 0;
int daystillevents = 0;

if(difficulty.equals("easy")){
    System.out.println("Setting stats to " + difficulty);
    food = 3000;
    foodperson = 5;
    energy = 0;
    hulltotal = 5000;
    hullhealth = 5000;
    enemy1basehealth = 10;
    enemy1basedamage = 1;
    daystillevents = 80;
}
System.out.println("food: " + food);