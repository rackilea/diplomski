Session session = getSession(serverUrl, username, password); // Get the session 

object = session.getObjectByPath(idObject); // get the object 

if (object.getAllowableActions().getAllowableActions().contains(Action.CAN_DELETE_OBJECT)) { //// You can delete 

   } else {  //// You can't delete 
       System.out.println("I can't ");            
   }