private int damageTaken;

public boolean takeDamage(int dmg) {
   damageTaken = dmg;
   hp -= dmg;

   reddish += 1.0f;

   if (hp <= 0) {

       return true;
   }
   return false;
}