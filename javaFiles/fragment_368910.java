for (Entry<String, List<String>> entry : m.entrySet()){ 
  System.out.println(entry.getKey() + "/" + entry.getValue()); 
  double calc=0,acc = 0, item;
  //First look for negative values
  for (Iterator<String> it=entry.getValue().iterator();it.hasNext();){
    item = Double.parseDouble(it.next());
    calc += item;
    if(item < 0){
      //accumulate them, and remove them from the list
      acc += item;
      it.remove();
    }
  }
  if(calc > 0){
    //now adjust the remaining positive numbers
    for (Iterator<String> it=entry.getValue().iterator();it.hasNext();){
      item = Double.parseDouble(it.next());
      //remove the number as we adjust it if it
      //is the last positive it will be reinserted
      //when the loop breaks
      it.remove();
      if((acc+=item) >= 0){
        //the accumulated numbers are now positive
        break;
      }
    }
    //re-insert the adjusted positive back into the list
    entry.getValue().add(0, Double.toString(acc));
  }else{
    //the total sum was negative or zero
    entry.getValue().clear();
    entry.getValue().add(Double.toString(calc));
  }
  System.out.println("Total for Item: " + entry.getKey() + " is "+calc);
  System.out.println("List is now: "+entry.getValue());
}