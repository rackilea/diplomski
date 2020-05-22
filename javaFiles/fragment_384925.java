public class OuterClass {
    Runnable printA = new Runnable() {
        @Override
        public void run() {
            System.out.println("Print A");
        }
    };
    Runnable printB = new Runnable() {
        @Override
        public void run() {
            System.out.println("MESSAGE:" + " " + "Print B");
        }
    };

    class PrintMessage implements Runnable {
        private String msg;
        public PrintMessage(String msg) {
            this.msg = msg;
        }

        // overloaded constructor
        public PrintMessage(String prefix, String msg) {
            this.msg = prefix + " " + msg;
        }


        @Override
        public void run() {
            System.out.println(msg);
        }
    }
    Runnable printC = new PrintMessage("Print C");
    Runnable printD = new PrintMessage("Print D");
    Runnable printE = new PrintMessage("MESSAGE:", "Print E");

    public static void main(String[] args) {
        OuterClass sample = new OuterClass();
        sample.printA.run();
        sample.printB.run();
        sample.printC.run();
        sample.printD.run();
        sample.printE.run();
    }
}