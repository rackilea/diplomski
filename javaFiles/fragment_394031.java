public final T save(T containable) {
    // if entity containable.getCompound already exists, it
    // must first be reattached to the entity manager or else
    // an exception will occur (issue in Spring Data JPA ->
    // save() method internal calls persists instead of merge)
    if (containable.getId() == null
            && containable.getCompound().getId() != null){
        Compound compound = getCompoundService()
                .getById(containable.getCompound().getId());
        containable.setCompound(compound);   
    }
    containable = getRepository().save(containable);
    return containable; 
}