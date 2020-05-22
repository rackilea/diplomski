public class Test{
    int Trails;
    int Days

    public Test(int numT, int numD){
        Trails = numT;
        Days = numD;
    }

    public static void main (String[] args){
        int numT;
        int numD;

        if(args.length!=0){
            numT = Integer.parseInt(args[0]);
            numD = Integer.parseInt(args[1]);

            //Create object here
            Test t = new Test(numT, numD);
        }
    }
}