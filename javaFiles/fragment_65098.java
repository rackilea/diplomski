............. 
 if(rs.next()) 
   {
         return SUCCESS; //the return atatement should be here. otherwise other statements should be evaluated.
   }
   else
   {
       addActionError("Invalid Username/Password"); 
       return ERROR;//here also
   }     
   } catch (Exception e) {
       e.printStackTrace();
       return ERROR;
   }