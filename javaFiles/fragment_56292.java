package files;

public class EndLoopWithBooleanMethod {
static boolean a = true;
public static void main(String[] args){

    while(a) {    //This is enough as a is a boolean, the complete thing would be
                  //whlie (a == true)
        EndLoop(a);
        System.out.print(".");
        EndLoop(a);
    }
}

public static void EndLoop(boolean var){
    var = false;  //a is set to false instead of the method returning false
}
}