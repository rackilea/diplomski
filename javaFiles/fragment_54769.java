public void setField (String val)
{
    try {
        int v = Integer.parseInt(val);
        setField (v);
    }
    catch (..) {
        ...
    }
}

public void setField (int val)
{
    // can add some range checks here
    this.val = val;
}