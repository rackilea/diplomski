int recursion(Object object)
{
    //do a little bit modification to the object
    int i1= recursion(object);
    //undo the modification to the object
    //do a little bit modification to the object
    int i2= recursion(object);
    //undo the modification to the object
    //do a little bit modification to the object
    int i3= recursion(object);
    //undo the modification to the object
    return max(i1, i2, i3);
}