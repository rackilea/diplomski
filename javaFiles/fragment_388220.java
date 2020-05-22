try {
Process 
 p=Runtime.getRuntime().exec("Sharpenter.ResumeParser.UI.Console.exe");
                       try{    p.waitFor();
                          }catch (InterruptedException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
}

                              System.out.println("Done.");

 } catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();