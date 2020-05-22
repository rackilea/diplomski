public class ConstructorExample {
    //this is your class fieald
    private double x,y;

    //here is the constructor with the single argument
    public ConstructorExample(int x){
       this.x = x;
    } 

    //here is the constructor with 2 arguments
    public ConstructorExample(int x,int y){
       //you can call another constructor with the arguments
       this(x);
       this.y = y;
    } 
    public static void main(String[] args) { 
        //here is how you can create a class instance inside the main method 
        ConstructorExample example = new ConstructorExample(1,1); 
    }    

}