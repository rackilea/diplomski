static Random rand = new Random();

int randomProductDiscount()
{
    int[] disc = {25,35,50}; 
    return disc[rand.nextInt(disc.length)];
}