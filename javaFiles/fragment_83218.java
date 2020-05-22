public class Test {
    public static void main(String[] args) throws Exception {
        if(args.length == 0)
            Runtime.getRuntime().exec("javaw Test loop");
        else
            while(true){}
    }
}