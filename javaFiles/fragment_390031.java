try{
    Process process;            
    process = Runtime.getRuntime().exec("top -n 1 -d 1");
    BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

} catch (InterruptedException e) 
{
    // TODO Auto-generated catch block
    e.printStackTrace();
}