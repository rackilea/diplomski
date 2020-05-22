Item list[] = new Item[10];

Set<Item> itemSet = new HashSet();


for(int i = 0; i < list.length; i++)
{   

    do{
    int random = (int)(Math.random() * 2);

        if(random == 0)
            list[i] = new Perish();
        else
            list[i] = new Nonperish();

        if(itemSet.contains(list[i])){
            continue;
        }else {
            itemSet.add(list[i]);
            break;
        }
    }while(true);

}