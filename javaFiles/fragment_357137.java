public class Example {
    private int empID = 0; //Creates a global variable

    public Example(int empID) { //Creates a local variable that is 
                                //initiated when contructor is called
        this.empID = empID; //Calls the global variable and sets it
                            //equal to the local variable
        exampleMethod(); //Calls the method below
    }

    private void exampleMethod() {
        empID = 1; //Sets the global variable to = 1
        //This is the same as this.empID = 1;
    }

    public void setEmpID(int newID) {
        empID = newID; //Sets the global variable to = newID
        //This is the same as this.empID = newID;
    }

    public int getEmpID() {
        return empID; //Gets the value of the global variable
                      //empID. Example use below
    }
}