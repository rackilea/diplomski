public static void main(String[] args) throws BrainException {
    //Declare all the axioms
    Brain brain = new Brain();
    brain.addClass("AlcoholicBeverage");
    brain.addClass("Beer");
    brain.subClassOf("Beer", "AlcoholicBeverage");
    brain.addClass("Wine");
    brain.subClassOf("Wine", "AlcoholicBeverage");
    brain.addClass("Person");
    brain.addObjectProperty("using");
    brain.addObjectProperty("drinking");
    brain.subPropertyOf("drinking", "using");
    brain.addObjectProperty("consuming");
    brain.subPropertyOf("consuming", "using");

    brain.addClass("AlcoholConsumer");
    brain.subClassOf("AlcoholConsumer", "Person");
    brain.equivalentClasses("AlcoholConsumer", "using some AlcoholicBeverage");

    //Add the queries
    brain.addClass("Query1");
    brain.equivalentClasses("Query1", "using some Beer");

    brain.addClass("Query2");
    brain.equivalentClasses("Query2", "drinking some Beer");

    brain.addClass("Query3");
    brain.equivalentClasses("Query3", "consuming some Wine");

    List<String> subClasses = brain.getSubClasses("AlcoholConsumer", false);
    //Should list all the queries
    System.out.println(subClasses);

   brain.sleep();
   brain.save("/home/samuel/Desktop/so.owl");
}