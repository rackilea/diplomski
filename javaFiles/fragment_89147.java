ProcessBuilder builder = new ProcessBuilder("java", "SecondApplication"); //without .class suffix
 builder.directory(new File("C:\\Users\\etc")); //I don't know you're on linux or windows. Just go to where your "SecondApplication" is located.
 Process process = builder.start();

 OutputStream pIn = process.getOutputStream();
 InputStream pOut = process.getInputStream();

 BufferedReader reader = new BufferedReader(new InputStreamReader(pOut));
 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pIn));