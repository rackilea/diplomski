File dir=new File("./resc");
if(!dir.exists()) {
    dir.mkdirs();
}
File analyticsFile=new File(dir,"analytics.py");
if(!analyticsFile.exists()) {
    /*
     * alternative:
     * this.getClass().getResourceAsStream("com/fortunamaritime/analytics.py")
     */
    try(InputStream analyticsIn = this.getClass().getClassLoader().getResourceAsStream("analytics.py")){
        Files.copy(analyticsIn, analyticsFile.toPath());
    }
}
/*
 * alternative: String command=String.join(" ",new String[]{"python",analyticsFile.getAbsolutePath(),"https://fortunamaritime.com.tr"});
 */
String command="python "+analyticsFile.getAbsolutePath()+" https://fortunamaritime.com.tr";
/*
 * alternative (without error redirection): Process p=Runtime.getRuntime().exec(command);
 */
ProcessBuilder builder = new ProcessBuilder(command);
builder.redirectErrorStream(true);
Process p=builder.start();