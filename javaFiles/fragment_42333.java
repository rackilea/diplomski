int localInt;
String testString;

public static void main(String[] args) {

    new Runnable() {
        public void run() {
            MainWork a = new MainWork(); 
            a.doWork();
        }
    };

}

public void doWork() {
    localInt = 1;
    testString = "Hi";
}