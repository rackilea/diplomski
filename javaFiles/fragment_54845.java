int size = myHashSet.size();
int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
int i = 0;
for(Object obj : myhashSet)
{
    if (i == item)
        return obj;
    i++;
}