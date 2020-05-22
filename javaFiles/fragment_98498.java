public static void main(String[] args){
    MainClass mainClass = new MainClass();
    try {
        ...
        // do main stuff here
        ...
    } finally {
        mainClass.threadInstance.interrupt();
    }
 }