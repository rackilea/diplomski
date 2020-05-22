public class ConstructorExample {
    //this is your class fieald
    private double x,y;

    //here is the constructor
    public ConstructorExample(int x,int y){
       //set the class field's values, via this (means class), 
       //because the arg names is the same as fields names
       this.x = x;
       this.y = y;
    } 

    public static void main(String[] args) { 
        //here is how you can create a class instance inside the main method 
        ConstructorExample example = new ConstructorExample(1,1); 
    }    
}