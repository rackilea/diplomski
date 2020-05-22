String[] str = {"imp", "ASKUL/askul@ASKDB file=askdbinstall.dmp", 
                "log=askul.log", "fromuser=askul", "touser=ASKUL", 
                "full=N ignore=Y grants=Y indexes=Y;"};

process = Runtime.getRuntime().exec(str);
BufferedReader in = 
           new BufferedReader(new InputStreamReader(process.getErrorStream()));
String line = null;
while ((line = in.readLine()) != null) {
    System.err.println(line);
}