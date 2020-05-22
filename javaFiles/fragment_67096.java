File buildFile = new File("build.xml");
Project p = new Project();
p.setUserProperty("ant.file", buildFile.getAbsolutePath());
p.init();
ProjectHelper helper = ProjectHelper.getProjectHelper();
p.addReference("ant.projectHelper", helper);
helper.parse(p, buildFile);
p.executeTarget(p.getDefaultTarget());