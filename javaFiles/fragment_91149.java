public class test 
{
    public static void main(String[] args)
    {
        Runtime rt = Runtime.getRuntime();
        String cmd[] = new String[] {"yum",  "-y", "install", "rpm-build"};
        Process ps = rt.exec(cmd);

        BufferedReader readerStd = new BufferedReader(new InputStreamReader(ps.getInputStream()));  

        BufferedReader readerErr = new BufferedReader(new InputStreamReader(ps.getInputStream()));  

        String line = null;  
        while ((line = readerStd.readLine()) != null) {  
            System.out.println(line);  
        }  
        System.out.println("------ Std Err -------");
        while ((line = readerErr.readLine()) != null) {  
            System.out.println(line);  
        }

        if (ps.waitFor()==0) {
            System.out.println("success");
        } else {
            System.out.println("Failed");
        } 
    }
}