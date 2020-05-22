private volatile int hashCode;
//You keep a member field on the class, which represents the cached hashCode value

   @Override public int hashCode() {
       int result = hashCode;
       //if result == 0, the hashCode has not been computed yet, so compute it
       if (result == 0) {
           result = 17;
           result = 31 * result + areaCode;
           result = 31 * result + prefix;
           result = 31 * result + lineNumber;
           //remember the value you computed in the hashCode member field
           hashCode = result;
       }
       // when you return result, you've either just come from the body of the above
       // if statement, in which case you JUST calculated the value -- or -- you've
       // skipped the if statement in which case you've calculated it in a prior
       // invocation of hashCode, and you're returning the cached value.
       return result;
   }