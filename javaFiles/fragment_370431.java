String ask()
{
    System.out.println(quesText);

    int input = numin.nextInt();

    if (input == 1)
    {
        System.out.println(quesAtr1); return quesAtr1;
    } else if (input == 2)
    {
        System.out.println(quesAtr2); return quesAtr2;
    } else if (input == 3)
    {
        System.out.println(quesAtr3); return quesAtr3;
    } else if (input == 4)
    {
        System.out.println(quesAtr4); return quesAtr4;
    } else
    {
        System.out.println("That is not a valid input. Possible inputs are: 1, 2, 3, 4."); System.out.println(""); return "";
    }
}