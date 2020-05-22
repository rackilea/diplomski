public class Test{
    int Trails;
    int Days

    public static void main (String[] args){
        //Create object of type Test
        Test t = new Test();

        if(args.length!=0){
            t.Trails = Integer.parseInt(args[0]);
            t.Days = Integer.parseInt(args[1]);
        }
    }
}