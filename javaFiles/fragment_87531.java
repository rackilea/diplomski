pb = new ProcessBuilder("./program")
         .redirectOutput(Redirect.INHERIT)
         .redirectError(Redirect.INHERIT);
Process p = pb.start();
OutputStream os = p.getOutputStream();
Files.copy( Paths.get("./my-file-1.txt"), os );
Files.copy( Paths.get("./my-file-2.txt"), os );
// more files

os.close();
int rc = p.waitFor();