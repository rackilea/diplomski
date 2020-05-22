GeneralCommandLine generalCommandLine = new GeneralCommandLine(cmds);
  generalCommandLine.setCharset(Charset.forName("UTF-8"));
  generalCommandLine.setWorkDirectory(project.getBasePath());

  ProcessHandler processHandler = new OSProcessHandler(generalCommandLine);
  processHandler.startNotify();