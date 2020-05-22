ArrayList deletedObjects = new ArrayList();
for (Iterator i = list.iterator(); i.hasNext();)
{
    Person o = i.next();

    o.update();

    if (list.isMarkedForDeletion())
    {
        deletedObjects.add(o);
    }
}

for (int i = 0; i < deletedObjects.size(); i++)
{
    list.remove(deletedObjects.get(i));
}