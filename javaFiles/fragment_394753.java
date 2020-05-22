public static void main(String[] args) throws Exception {

    doCalculation(3,5);  //call the method with two arguments
    doCalculation(7,2);  //call the method again with other arguments

}

//define a method in this way: visibilty, return typ, name, arguments
public static int doCalculation(int numb1, int numb2) {   
    int result = numb1 * numb2;                         
    return result;
}