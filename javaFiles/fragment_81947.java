CompletableFuture<List<ParentObject>> populateAsync(List<ParentObject> parents) {

  //get the children of each parent in parallel, store the futures in a list
  List<CompletableFuture<ParentObject>> futures = 
    parents.stream() 
           .map(parent ->
                   parentObjectDao.getChildrenForParent(parent.getId())
                                  .thenApply(parent::setChildren))  //assuming setChildren returns the parent object
           .collect(Collectors.toList()); //we need this stream terminal operation to start all futures before we join on the first one

  //wait for all of them to finish and then put the result in a list
  return CompletableFuture.supplyAsync(() -> 
                                     futures.stream()
                                            .map(CompletableFuture::join)
                                            .collect(Collectors.toList());    
}