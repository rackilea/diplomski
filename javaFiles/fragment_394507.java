url = "jdbc:virtuoso://localhost:1111";
VirtGraph set = new VirtGraph ("test1", url, "dba", "dba");

set.clear();

String qry = "INSERT INTO GRAPH <test1> { <aa> <bb> 'cc' . <aa1> <bb> 'zz' }";
VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(qry, set);
vur.exec();                  

Model inputModel = new VirtModel(set);
System.out.println("InputModel :"+inputModel);
System.out.println("InputModel size :"+inputModel.size());
System.out.println();


qry = "CONSTRUCT { ?x <a> ?y } WHERE { ?x <bb> ?y }";
QueryExecution vqe = VirtuosoQueryExecutionFactory.create (qry, inputModel);

Model model = vqe.execConstruct();
System.out.println("Model :"+model);
System.out.println("Model size :"+model.size());