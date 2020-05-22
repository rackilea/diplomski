System.out.println("Launching command: "+command);
ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", command);
Process proc=pb.start();

PipeStream out=new PipeStream(proc.getInputStream(), System.out);
PipeStream err=new PipeStream(proc.getErrorStream(), System.err);
out.start();
err.start();

proc.waitFor();
System.out.println("Exit value is: "+proc.exitValue());