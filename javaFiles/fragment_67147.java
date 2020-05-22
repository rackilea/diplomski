String current_directory = System.getProperty("user.dir");

 ProcessBuilder builder=new ProcessBuilder(current_directory+"\\"+ "myCmdFile.cmd");
 builder.directory(new File(current_directory));
 File log = new File("log.txt");
 builder.redirectErrorStream(true);
 builder.redirectOutput(Redirect.appendTo(log));
 Process process=builder.start();
 process.waitFor();
 System.out.println("CMD file executed");