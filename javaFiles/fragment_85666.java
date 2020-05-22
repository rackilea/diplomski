static JenaOWLModel owlModel ;
public static void main(String[] args) {

    OntModel model;
    javax.swing.JDialog jDialog1 = new javax.swing.JDialog();       
    try{
        String ns="file:///D:/base_connaissance.owl#";
        owlModel = ProtegeOWL.createJenaOWLModelFromURI("file:///D:/base_connaissance.owl");//  crée  un modele owl  a partir du ficher owl charger
        model = owlModel.getOntModel();  
        JOptionPane.showMessageDialog(jDialog1,"chargement du fichier  effectuer avec succé","Information",JOptionPane.INFORMATION_MESSAGE);        

        ArrayList<Resource> results = new ArrayList<Resource>();            
        ExtendedIterator  individuals = model.listIndividuals();
        while (individuals.hasNext()) {
            Resource individual = (Resource) individuals.next();
            results.add(individual);
        }
        System.out.println("\n");

        for(int i = 0; i < results.size(); i++)
        {
        Individual ind = model.getIndividual(results.get(i).toString());
        System.out.println(""+ind);
        StmtIterator it = ind.listProperties();

        while ( it.hasNext()) {
               Statement s = (Statement) it.next();    

            if (s.getObject().isLiteral()) {


                System.out.println(""+s.getLiteral().getLexicalForm().toString()+" type = "+s.getPredicate().getLocalName());

                }


            else    System.out.println(""+s.getObject().toString().substring(53)+" type = "+s.getPredicate().getLocalName());


                 }
        System.out.println("\n");
            }


    }
    catch(Exception e){
        JOptionPane.showMessageDialog(jDialog1,
                "error",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
}