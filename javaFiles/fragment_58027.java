public static void main(String[] args) {


    int k = 10;
    double [] arr = {0,1,2,3,4,5};
    System.out.println("Enter you K");
    new Dot(); // the classloader loads the Dot class
    MyVector vec = new MyVector();  // that line compile ,but when debugging it crashes , why ? 
    MyVector vec2 = new MyVector(arr);


}