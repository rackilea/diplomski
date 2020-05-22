Context con = new Context();
Series<Parameter> clParameters = con.getParameters();
clParameters.add("truststorePath", "*.jks file");
clParameters.add("truststorePassword", "password");
clParameters.add("truststoreType", "JKS");
Client restletClient = new Client(con, Protocol.HTTPS);