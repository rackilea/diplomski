class Problem {
  private String longString;
  private String firstHalf;
  private String secondHalf;

  //Getters of All Variables
    ......
    ......
    ......

  // Setters of All Variables.

  public void setLongString(String longString){
     this.longString = longString;
     }

  // public but no Arguments so that user won't be able to set this Explicitly but 
  //make a call Outside of the Class to set Only and only if longString is there.

  public void setFirstHalf(){   
       if(this.longString == null)
            throw new Exception("Long String is Not Set.");
       this.firstHalf = this.computeFirstHalf(this.longString);
   }

     // public but no Arguments so that user won't be able to Set Explicitly but 
    //make a call Outside of the Class to set Only and only if longString is there.

   public void setSecondHalf(){  
       if(this.longString == null)
            throw new Exception("Long String is Not Set.");
       this.secondHalf = this.computeSecondHalf(this.longString);
   }
//private method not Accessible outside of Class
   private String computeFirstHalf(final String value){ 
     //Your Logical Code. 
    }
 //private method not Accessible outside of Class
   private String computeSecondHalf(final String value){ 
        //Your Logical Code.
}