int min = 0;
int max = 10;
int array[] = new int[max + 1];

int filledArray = 0;

while(filledArray < max + 1) // Condition to not keep iterating forever
{
    do 
    {
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);

    } while (array[random] == 1);

    array[random] = 1;
    filledArray++;
}