public class SoapMiddleMan extends Thread {

private String zip;
private SoapSenderClass cs;

public void run(){

    try{
         cs=new SoapSenderClass();
         String resp=cs.getWeather(zip);
         MainActivity.rslt=resp; //public string in calling activity
         System.out.println("reached 2 \n");
        }catch(Exception ex)

        {
            MainActivity.rslt=ex.toString();
        }


        MainActivity.thread = "done";
    }

public void setZip(String searchZip)
{
    zip = searchZip;
}

}