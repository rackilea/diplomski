Project project = new Project();
project.setName("myproject");
project.init();

Target target = new Target();
target.setName("junitreport");
project.addTarget(target);

FileSet fs = new FileSet();
fs.setDir(new File("./junitreports"));
fs.createInclude().setName("*.xml");
XMLResultAggregator aggregator = new XMLResultAggregator();
aggregator.setProject(project);
aggregator.addFileSet(fs);
AggregateTransformer transformer = aggregator.createReport();
transformer.setTodir(new File("./testreport"));

target.addTask(aggregator);
project.executeTarget("junitreport");