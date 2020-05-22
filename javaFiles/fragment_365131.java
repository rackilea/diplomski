public class NetStat 
{
    public static void main(String [] args) throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter port number :");
        String port =br.readLine();
        StringBuffer output = new StringBuffer();
        Process p = Runtime.getRuntime().exec("netstat -an");
        BufferedReader reader = 
                 new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";           
        while ((line = reader.readLine())!= null) {
            if(line.contains(port))
            {
                output.append(line + "\n");
            }
        }

        System.out.println(output.toString());

    }
}


Input: 50773
Output: TCP    1xx.xxx.xxx.xxx:50773   xxx.xxx.xxx.xxx:8080    ESTABLISHED