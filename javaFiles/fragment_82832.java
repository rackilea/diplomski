File folder = new File("G:\\OWL and OBO");
File[] listOfFiles = folder.listFiles();
for (int i = 0; i < listOfFiles.length; i++) {
    if (listOfFiles[i].isFile()) {
        OWLOntologyManager owlManager = OWLManager.createOWLOntologyManager(); 
        System.out.println("File " + listOfFiles[i].getName());
        try{
            File sourceFile = new File( "G:\\OWL and OBO\\" + listOfFiles[i].getName());
            OWLOntology ontology = owlManager.loadOntologyFromOntologyDocument(sourceFile);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}