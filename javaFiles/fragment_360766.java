//Return true if name is valid
private boolean validName(String str)
{
    if(str == null || str.length() == 0)
        return false;
    return str.toLowerCase().matches("[a-z]+"); //Name only has a-z(A-Z)
}