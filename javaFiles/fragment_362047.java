for(OWLObjectPropertyRangeAxiom range:moduleOWL.getObjectPropertyRangeAxioms(oop)) {
    for(OWLEntity rangeStr : range.getSignature()) {
    //System.out.println("\t\t ==========: " + rangeStr );
    if(!rangeStr.containsEntityInSignature(oop)) {
     System.out.println("\t\t -: " + rangeStr.toString().replaceAll("<|>", "") );
     str = rangeStr.toString().replaceAll("<|>", "");
    }
    }
}