public static void main(String [] args) {
    Example.multiValueExample(Values.ONE | Values.THREE | Values.FIVE);
}

public static void multiValueExample(int values){
    if ((values & Values.ONE) == Values.ONE) {
    }

    if ((values & Values.TWO) == Values.TWO) {
    }

    // etc.
}