private boolean isValidStateProvinceName(String validName)
{
    for(String temp : validStateProvince)
    {
        if(temp.equalsIgnoresCase(validName)) {
            return true;
        }
    }
    return false;
}