import java.io.*;


class Pat
{
    public static void main(String args[])
    {
        int num = validate("[123]");
        System.out.println(num);
    }

    static int validate(String pattern)
    {
        String input = "";
        boolean validInput = false;
        do
        {
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine();
                if(input.matches(pattern))
                    validInput = true;
            }catch(Exception e)
            {
                System.out.println("" + e);
            }
        }while(!validInput);
        return Integer.parseInt(input);
    }
}