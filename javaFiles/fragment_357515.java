int sim = 0;
int nb=4;

System.out.print("The five random numbers are: ");
for (int i = 0; i <= nb; i++)
{
    sim += (int)(Math.random()*2.9999) + 1;

    if ( i < nb ) {
        System.out.print(sim + ", ");
    } else {
        System.out.print("and " + sim + ".");
    }
}