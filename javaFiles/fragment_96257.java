Project project = new Project();
File buildFile = inputFile.getFile();
project.setUserProperty("ant.file", buildFile.getAbsolutePath());
ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
project.addReference("ant.projectHelper", projectHelper);
//ProjectHelper.configureProject(project, buildFile);
projectHelper.parse(project, buildFile);
//you can use either static method configureProject of ProjectHelper or normal parse method.