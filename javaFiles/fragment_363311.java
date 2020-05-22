public class Test {
    public static void main(String... args) {
        if(args.length==0) {
            final boolean meFirst = Math.random()<0.5;
            if(meFirst) {
                Runnable r=Test::main;
                System.out.println("first run:\t"+r.getClass());
            }
            main("second run");
            if(!meFirst) {
                Runnable r=Test::main;
                System.out.println("first run:\t"+r.getClass());
            }
        }
        else {
            Runnable r=Test::main;
            System.out.println(args[0]+":\t"+r.getClass());
            if(args[0].equals("second run")) main("last run");
        }
    }
}