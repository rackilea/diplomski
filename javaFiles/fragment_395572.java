private String _concatenateBase(String one, String two) 
{
    return one + two;
}


public String concatenate(String one, String two, String three) 
{
    return _concatenateBase(one+two, three);
}