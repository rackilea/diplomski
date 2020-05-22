public <D extends BaseClass> boolean doIt (ArrayList<D> target, Class<D> c)
{
    try {
        D newElem = c.getDeclaredConstructor(int.class).newInstance(5);
    } catch (Exception e) {}

    // ...other code does not matter...

    return true ;
}