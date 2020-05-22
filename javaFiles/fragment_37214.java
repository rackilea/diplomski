LinkedList<Integer> list = new LinkedList<>();
final int min = 0;
final int max = 10;

while(list.size() < max) // Condition to not keep iterating forever
{
    do 
    {
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);

    } while (list.contains(random));

    list.add(random);
}