After Setting display to "1.0" with following code manually problem has been resolved and  i am able to access Open Office from web application to generate report

oooExeFolder = "/usr/lib/openoffice.org3/program/";
List<String> oooOptions = OOoServer.getDefaultOOoOptions();
oooOptions.add("-display");
oooOptions.add(":1.0");

OOoServer server = new OOoServer(oooExeFolder, oooOptions);
XComponentContext xContext = BootstrapSocketConnector.bootstrap(oooExeFolder);