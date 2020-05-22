private LinkedList<Combination> recursiveConfiguration(LinkedList<Combination> combinations){

    for(Combination c: combinations){
        c.add(this);
    }

    // Iterate through all edges of the current node
    for(Edge e: getEdges()){

        int type = e.getType();     

        if((type == 1) || (type == 2)){
            // If type is mandatory or optional.

            // In this case getChildren always returns only one feature.
            LinkedList<Combination> copyConfig = new LinkedList<>();

            for(Combination c: configurations){
                @SuppressWarnings("unchecked")
                LinkedList<FeatureNode3> copy = (LinkedList<FeatureNode3>) c.getFeatureList().clone();
                Combination config = new Combination();
                config.setFeatureList(copy);
                copyConfig.add(config);
            }

            FeatureNode3 child = e.getChildren().get(0);    
            LinkedList<Combination> childCombinations = child.recursiveConfiguration(copyConfig);

            if(type == 1){
                // If type is mandatory
                combinations = childCombinations;
            }else{
                // If type is optional
                combinations.addAll(childCombinations);
            }   
        }
    }           
    return combinations;
}