List<MailItem> listItem = mailbox.get(who, new ArraysList<>());  //get list if key exists or else get empty list

 if(!listItems.isEmpty()) {
      return listItems.remove(0);    //if list has items delete at index 0
   }
 else{
    System.out.println("that user dosent have a mailbox");
    return null;
  }