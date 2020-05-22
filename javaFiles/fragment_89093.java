File commands = new File("absolute path to inputs file");
File dirOut = new File("absolute path to outputs file");
File dirErr = new File("absolute path to error file");

dirProcess.redirectInput(commands);
dirProcess.redirectOutput(dirOut);
dirProcess.redirectError(dirErr);