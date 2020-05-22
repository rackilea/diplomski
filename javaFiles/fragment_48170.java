liste = new File('filename to read from').readLines()

jlc = new jenkins.model.JenkinsLocationConfiguration();
println jlc.getUrl()
println jlc.getAdminAddress()
jlc.setUrl("http://" + liste[0] + ":8080/jenkins/");
jlc.setAdminAddress(liste[1]);

println ("Set url to: http://" + liste[0] + ":8080/jenkins/")
println ("Set AdminAddress to: " + liste[1])
println "JenkinsLocation updated!"