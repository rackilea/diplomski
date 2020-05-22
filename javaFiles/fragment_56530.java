public static void main(String []args){
    String test="[\"1\",\"Low-level programming language\",true],[\"2\",\"High level programming language\",false],[\"3\",\"Machine language\",false],[\"4\",\"All of the above\",false],[\"5\",\"None of these\",false]";
    String [] splitStrings = test.split("(?!\\]),(?=\\[)");

    System.out.println(splitStrings[0]);
    System.out.println(splitStrings[1]);
    System.out.println(splitStrings[2]);
    System.out.println(splitStrings[3]);
    System.out.println(splitStrings[4]);
}