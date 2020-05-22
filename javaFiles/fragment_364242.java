// xargs -0 expects arguments on stdin separated by NUL characters
ProcessBuilder pb = new ProcessBuilder("xargs", "-0", "myScript.sh");
pb.environment().put("LANG", "de_DE.UTF-8"); // or whatever locale you require
Process p = pb.start();
OutputStream out = p.getOutputStream();
out.write("argument_with_letters_äöü".getBytes("UTF-8")); // convert to UTF-8
out.write(0); // NUL terminator
out.close();