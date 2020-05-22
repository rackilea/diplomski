for(MavenBuild items : mavenJob.getBuilds())
 {

    details=items.details();
    System.out.println(details.getFullDisplayName());
 }