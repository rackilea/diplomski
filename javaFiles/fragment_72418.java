public Set<Attribute> fetchAssociates(){
    Set<Attribute> associations = new HashSet();
    Metamodel model = this.entityManager.getMetamodel();
        EntityType cEntity = model.entity(this.persistentClass);
        System.out.println("Current Entity "+cEntity.getName());
        Set<Attribute> attributes =cEntity.getAttributes();
        for(Attribute att : attributes){
            if(att.isAssociation()){
                associations.add(att);
            }
        }
    return associations;
}