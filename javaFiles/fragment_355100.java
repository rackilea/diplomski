boolean valid = true;

char[] a = s.toCharArray();

for (char c: a)
{
    valid = ((c >= 'a') && (c <= 'z')) || 
            ((c >= 'A') && (c <= 'Z')) || 
            ((c >= '0') && (c <= '9'));

    if (!valid)
    {
        break;
    }
}

return valid;