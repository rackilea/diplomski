public static void main(String[] args) {
    ParentClass obj1= new ParentClass();

    // Set i for ALL ParentClass instances to 10
    obj1.i=10; 

    // See below.  When you come back from this method, ParentClass.i will be 25
    obj1.printvalue(); 

    // Print the value of i that was set in printValue(), which is 25
    System.out.println("The value of i is " +i); /
}

public void printvalue() {
    ParentClass obj1= new ParentClass(); 

    // Create a new local variable that shadows ParentClass.i
    // For the rest of this method, i refers to this variable, and not ParentClass.i
    int i =30; 

    // Set i for ALL ParentClass instances to 25 (not the i you created above)
    obj1.i=25; 

    // Print the local i that you set to 30, and not the static i on ParentClass
    System.out.println("The value of i in the method is " +i); 
}