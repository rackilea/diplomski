public static String getOperatorType(String expression)
{
    int counter=0;

    for (int i=0; i<3; i++)
    {
        if (Character.isLetter(expression.charAt(i)))
            counter++;
    }

    if (counter==3)
        return "Trigonometrical";
    else
        return "Arithemtic";
}