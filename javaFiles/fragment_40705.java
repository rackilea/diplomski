Scanner scan = new Scanner("3\n" +
        "\n" +
        "1 45 5 3 5 Fizz Buzz FizzBuzz Nil\n" +
        "\n" +
        "4 13 10 2 7 Ba Bi Be Bu\n" +
        "\n" +
        "49 23 5 5 10 Oong Greeng Kattu Eswah");

ArrayList<String> strings = new ArrayList<>();
ArrayList<Integer> ints = new ArrayList<>();
while(scan.hasNext()){
    String word=scan.next();
    try {
        ints.add(Integer.parseInt(word));
    } catch(NumberFormatException e){
        strings.add(word);
    }
}

scan.close();

System.out.println(ints);
System.out.println(strings);