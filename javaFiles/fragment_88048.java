StringBuilder fileOutput = new StringBuilder();
//your per line logic
//instead of out.write() use fileOutput.append()
System.out.println(String.format("File.canWrite() says %s", inputFile.canWrite());
PrintWriter fileToWrite = new PrintWriter(inputFile);
fileToWrite.println(fileOutput.toString());
fileToWrite.close();