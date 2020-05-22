Process p = Runtime.getRuntime().exec("c:/cygwin/bin/bash.exe");
OutputStreamWriter osw = new OutputStreamWriter(p.getOutputStream());
BufferedWriter bw = new BufferedWriter( osw, 100);
try{
    bw.write(command);
    bw.close();
}catch(IOExeception e){
    System.out.println("Problem writing command.");
}