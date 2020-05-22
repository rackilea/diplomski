Process p = Runtime.getRuntime().exec(args);
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream()));

StreamHandler outputHandler = new StreamHandler(in);
outputHandler.start();

StreamHandler errorHandler = new StreamHandler(err);
errorHandler.start();