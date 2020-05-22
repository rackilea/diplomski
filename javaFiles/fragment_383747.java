public void setName (String name)
    throws NameException
{
    if (name == null || name == "")
        throw new MissingNameException ();
    if (name.length > 30)
        throw new InvalidNameException (name); // this exception can contain a message that explains why the
                                               // name is invalid and what a valid name looks like
    _name = name;
}