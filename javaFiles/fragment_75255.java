if (summariserName.length() > 0) {  
    summer = new Summariser(summariserName);  
  }  

  String logFile = "D:/apache-jmeter-5.1.1/extras/resultss.xml";
  ResultCollector logger = new ResultCollector(summer);  
  logger.setFilename(logFile);
  testPlanTree.add(testPlanTree.getArray()[0], logger);