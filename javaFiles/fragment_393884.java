Iterator<Individual> iterInd = model.listIndividuals();
while (iterInd.hasNext()) {
    Individual ind = iterInd.next();
    if (ind.getLocalName().equalsIgnoreCase(input)) {
        System.out.println("Synonyms of " + ind.getLocalName() + " are:");
        NodeIterator iterVal = ind.listPropertyValues(isSynonymOf);
        while (iterVal.hasNext()) {
            System.out.println(" * " + iterVal.next().getLocalName());
        }
    }
}