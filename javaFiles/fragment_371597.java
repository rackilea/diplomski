boolean incorrectNumberFormat;
do
{
    incorrectNumberFormat = false;
    try
    {
        System.out.println("Sisesta number:");
        System.out.println("Kaks komakohta on lubatud");
        num = sisse1.nextFloat();
    }

    catch(InputMismatchException exception) //juhul kui sisestab miskit muud
    {
        System.out.println("Kontrolli kas kasutasid koma!");
        sisse1.nextLine();
        incorrectNumberFormat = true;  //repeat the loop;
    } 
} while(incorrectNumberFormat);