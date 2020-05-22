Session session = getSession();
  AgentContext agentContext = session.getAgentContext();
  Directory dir = session.getDirectory("NameOfYourServer");
  String userName=session.getUsername(); 
  DirEntryCollection direc = dir.lookupNames("($Users)",userName,"email");
  DirEntry dirent = direc.getFirstEntry()
  while (dirent != null) {
    String name = dirent.getItemValue("InternetAddress");
    System.out.println(InternetAddress);
    dirent = direc.getNextEntry(); }