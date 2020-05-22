private int countRepeatedChars(String password) {
    int countMax = 0;
    int count = 1;
    int pos = 1;

    if(password != null && password.length() > 1)
    {
        for(pos = 1;pos < password.length();pos++)
        {
            if(password.charAt(pos) == password.charAt(pos - 1))
            {
                count++;
            }
            else
            {
                count = 1;
            }

            if(count > countMax)
            {
                countMax = count;
            }
        }
    }
    else if(password != null)
    {
        countMax = 1;
    }

    return countMax;
}