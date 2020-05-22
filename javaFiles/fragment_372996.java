public static void main(String[] args) {

    final int numOfTrials = 100000;

    long first = 0;
    for (int index = 0; index < numOfTrials; index++) {
        long start = System.nanoTime();
        final String string1 = "somestring1";
        for (int i = 0; i < 30; i++) {
            final String string2 = "somestring2";
            if (string2.equals(string1)) { // Using variable
                // do stuff
            }
        }
        first+= (System.nanoTime()-start);
    }

    long second = 0;
    for (int index = 0; index < numOfTrials; index++) {
        long start = System.nanoTime();
        for (int i = 0; i < 30; i++) {
            final String string2 = "somestring2";
            if (string2.equals("somestring1")) { // Not using variable
                // do stuff
            }
        }
        second+= (System.nanoTime()-start);
    }


    System.out.println("First : "+(first/numOfTrials)+"ns");
    System.out.println("Second : "+second/numOfTrials+"ns");
}