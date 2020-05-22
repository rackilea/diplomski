Process p=Runtime.getRuntime().exec("cmd.exe /c ping 127.0.0.1 -n 10");

System.out.println("Here 1");//this will execute immediately

try {

    p.waitFor();

    System.out.println("Here 2");//this will only be seen after +- 10 seconds and process has finished

} catch (InterruptedException ex) {
   ex.printStackTrace(); 
}