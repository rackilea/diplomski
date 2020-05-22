int value;

public void setIntField (String value) 
  throws SomeException
{
    if (value == null)
        throw new SomeException();
    try {
        int val = Integer.parseInt (value);
        setIntField (val);
    }
    catch (NumberFormatException ex) {
        throw new SomeException();
    }
}

public void setIntField (int value)
    throws SomeException ()
{
    if (value < MIN_ALLOWED || value > MAX_ALLOWED)
        throw new SomeException ();
    this.value = value;
}