if (containsKey(who) ){      // if key exists then proceed
   MailItem item2 = mailbox.get(who).get(0);
   mailbox.get(who).remove(0);
   return item2; }
else{                   // else don't proceed 
    System.out.println("that user dosent have a mailbox");
    return null;
}