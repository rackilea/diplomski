public void insert(Integer obj)

{

 //...
else
{
    tree.add(obj)
    int place = tree.size()-1;
    int parent = (place -1)/2;

    while(parent >= 0 && (tree.get(place) > tree.get(parent)))
    {
        swap(tree, place, parent);
        place=parent;
        parent = (place -1)/2;
    }
    System.out.println(tree);

}