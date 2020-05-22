public Boolean validate(String dueDate,Double unpaid,Double amount) 
      throws OverLimitException{
      ...
      if(daysDiff > 45 || unpaid > 2000){
          throw new OverLimitException("Further Transactions Not Possible  until clearance of bill.");
    }
    ...

}