public  class   W05Practical {
    public  static  void   main(String[] args){
        boolean correctInput = false;

        while(!correctInput){
            System.out.println("Please enter the lengths/distance in meters:");
            int Distance = EasyIn.getInt();

            if (Distance >= 0) {
                System.out.println("Thank you");
                correctInput = true;
            }else { 
                System.out.println("Distance can not be negative. \nPlease enter the appropriate distance:");
            }  
        }    
    }
}