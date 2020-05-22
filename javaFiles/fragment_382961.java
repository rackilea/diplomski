boolean inDigits = false;
for (int i = 0; i < string.length(); i++)
{
    char c = string.charAt(i);

    if (Character.isDigit(c)) {
        if (!inDigits) count++;
        inDigits = true;
    } else {
        inDigits = false;
    }
}