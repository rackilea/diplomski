/**
 * @return a random number, r, in the range -n <= r < n
 */
public static double getRandom(double n) {
   return Math.random()*n*2 - n;
}