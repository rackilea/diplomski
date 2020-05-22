public List<Integer> getChildrenIds(Integer parentId, List<Category> categories){
    Set<Integer> knownParents = new HashSet<>();
    List<Integer> result = new LinkedList<>();
    for(Category category : categories){
        // if category has the parent we're looking for
        if(category.parentId.equals(parentId)){
            // then add it to our result
            result.add(category.id);
            // this check is used to get all the children recursivly
            // but should be done only once, which is why we are using an intermediate set
            if(!knownParents.contains(category.id)){
                knownParents.add(category.id);
                result.addAll(getChildrenIds(category.id, categories));
            }            
        }
    }
    return result;
}