public class Level1ZombieClass
{
    int playerClass;
    int userhealth;
    <type> otherParam;
    ...

public Level1ZombieClass (int playerClass){
    this.playerClass = playerClass;
    this.userhealth = userhealth;
    this.otherParam = otherParam;
    ...
}

public void ZombieLevel1Class()
{
   Scanner in = new Scanner(System.in);
   //Variables that are not user-dependent
   int comphealth=100;
   int hc;
   int userChoice=1;
   int critdamage;

   //rest of code