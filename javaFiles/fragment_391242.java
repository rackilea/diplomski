// example code with no exception handling; add as needed for your program

String cmd = "ssh-keygen -y -f privatefile";
File out = new File ("publicfile"); // only for first two methods

//// use the stream ////
Process p = Runtime.exec (cmd);
Files.copy (p.getInputStream(), out.toPath());
p.waitFor(); // just cleanup, since EOF on the stream means the subprocess is done

//// use redirection ////
ProcessBuilder b = new ProcessBuilder (cmd.split(" "));
b.redirectOutput (out);
Process p = b.start(); p.waitFor();

//// use shell ////
Process p = Runtime.exec ("sh", "-c", cmd + " > publicfile");
// all POSIX systems should have an available shell named sh but 
// if not specify an exact name or path and change the -c if needed 
p.waitFor();