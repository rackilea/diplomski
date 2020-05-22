public Parent downcast(Child c)
{
    Parent cast = new Parent();
    //Transfer data from the child to the parent
    cast.setProperty(c.getProperty());
    return cast;
}