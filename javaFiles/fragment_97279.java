File pathToExecutable = new File( "resources/external.exe" );
ProcessBuilder builder = new ProcessBuilder( pathToExecutable.getAbsolutePath(), "-i", "input", "-o", "output");
builder.directory( new File( "resources" ).getAbsoluteFile() ); // this is where you set the root folder for the executable to run with
builder.redirectErrorStream(true);
Process process =  builder.start();

Scanner s = new Scanner(process.getInputStream());
StringBuilder text = new StringBuilder();
while (s.hasNextLine()) {
  text.append(s.nextLine());
  text.append("\n");
}
s.close();

int result = process.waitFor();

System.out.printf( "Process exited with result %d and output %s%n", result, text );