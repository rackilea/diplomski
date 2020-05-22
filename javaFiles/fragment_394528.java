BuildLogger logger = new DefaultLogger();
logger.setOutputPrintStream(System.out);
logger.setErrorPrintStream(System.err);
logger.setMessageOutputLevel(Project.MSG_INFO);
logger.setEmacsMode(true);
project.addBuildListener(logger); //add build listener to your define project