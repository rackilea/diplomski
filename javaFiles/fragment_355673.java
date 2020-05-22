public class MyValidator implements Validator {
    @Override
    public boolean isValid(Object value) {
        //check if your object is new or existent
        if(((BeanObject)value).getID()==null)){
        //non-existent entity, also check the unique account constraint 
             if(accountExists()) {
                   return false;
             }
             else {
                   return true;
             }
         }

         //common checks....
         {....} 

    }
....
}