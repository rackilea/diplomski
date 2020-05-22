final int PAGE_SIZE = 100;
int numberOfPages = -1;
int currentPage = -1;

public void initializeVariables(){
  paging.setTotalRec(availableList.size());
  showFrom = 1; 
  showTo = PAGE_SIZE;
  //keep track of how many pages there should be
  numberOfPages = paging.getTotalRec()/PAGE_SIZE;
  currentPage = 1;
}

public void handlePagingAction(){
  if(paging.getAction().equalsIgnoreCase("Next")){
     if(currentPage < numberOfPages){
        ++currentPage;
     }
  }else if(paging.getAction().equalsIgnoreCase("Previous")){
     if(currentPage > 1){       
       --currentPage;
     }
  }      

  showFrom = (currentPage - 1) * PAGE_SIZE + 1;
  if(showFrom < 0){
    showFrom = 0
  }

  showTo = currentPage * PAGE_SIZE;
  if(showTo >= paging.getTotalRec()){
    showTo = paging.getTotalRec();
  }     

  paging.setShowTo(showTo);
  paging.setShowFrom(showFrom);
}