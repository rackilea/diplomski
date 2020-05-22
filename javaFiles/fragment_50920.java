class extRight {

public static int extRight1(int x) {

    x = x % 10; 
     return x;

}

public static void main(String[] args){
    //do not forget  to pass command line args to program like this "java extRight 1"   
    int s = extRight1(Integer.parseInt(args[0]));// change indices to assign different arg[] values
   //  String o = Integer.toString(s)  you dont have to do this you can directly write
    System.out.print(s);

}

}