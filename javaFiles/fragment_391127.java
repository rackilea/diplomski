MavenXpp3Reader mavenreader = new MavenXpp3Reader();

File pomfile = new File("pom.xml");
Model model = mavenreader.read(new FileReader(pomFile));

List<Dependency> deps = model.getDependencies();

for (Dependency d: deps) {          
    System.out.print(d.getArtifactId());
}