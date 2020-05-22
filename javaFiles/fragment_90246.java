JenkinsServer js = new JenkinsServer(URI.create("Your Jenkins URL"));
MavenJobWithDetails mavenJob = js.getMavenJob("Your project Name inside server");
//get last Successful build
BuildWithDetails details = mavenJob.getLastSuccessfulBuild().details();
//get job details
 System.out.println("Build Number: " + details.getNumber());