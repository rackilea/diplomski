ITDConnection QCConnection =null;
try{
  QCConnection = ClassFactory.createTDConnection();
  QCConnection.initConnection("QC URL", domain, domainPswd);
  IList domains = QCConnection.domainsList();
  IList projectList = QCConnection.projectsList();
  List<String> domainList = new ArrayList<String>();
  for(int i=1;i<domains.count();i++){
    domainList.add((String)domains.item(i));
    System.out.println("DOmains: "+domains.item(i));
  }
  for(int i=1;i<projectList.count();i++){
    System.out.println("Projects : "+projectList.item(i));
  }
  QCConnection.connectProject(project, "LoginName", "Password");
  ITreeManager iTreeManager = QCConnection.treeManager().queryInterface(ITreeManager.class);
  ISubjectNode iSubNode = iTreeManager.nodeByPath("Subject").queryInterface(ISubjectNode.class);

  IList testFolders = iSubNode.newList();
  for(Com4jObject isys:testFolders){
    System.out.println("Test folder : "+isys.queryInterface(ISysTreeNode.class).name());
  }
}
catch(Exception e){
  System.out.println("Exceptions occured: "+e.getMessage());
}