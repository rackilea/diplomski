Iterator<Item> iter = items.iterator();
while (iter.hasNext()) 
{
    Item item = iter.next();
    if (item instanceof Monster)
    {
        Monster monster = (Monster)item; 
        if (monster.hasDied())
        {
            if (monster.getLocation() == location)
            {
                System.out.println(monster.getDescription() + " has been defeated!");
                iter.remove();
            }
            else
            {
               iter.remove(); 
            }
        }
    }
}