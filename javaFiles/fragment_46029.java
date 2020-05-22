class IdDisplay implements Runnable
{
    String  idNumber;
    char [] idMine;

    IdDisplay(String ID)
    {
        this.idNumber = ID;
        this.idMine = this.idNumber.toCharArray();
    }

    public void run()
    {
        for(int i = 0; i < idMine.length; i++)
        {
            System.out.print(idMine[i] + " ");
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException in){}
        }
    }       
}