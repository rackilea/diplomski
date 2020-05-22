if((Integer)list.get(j)>(Integer)list.get(j+1))
{
    int temp=(Integer)list.get(j+1);
    list.set(j+1, (Integer)list.get(j));
    list.set(j, temp);
    status++;
}