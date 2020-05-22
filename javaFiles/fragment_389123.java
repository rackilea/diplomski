double prevClose = 0;

String test = "this is a test test test stop 123 3.5";
Scanner parse = new Scanner(test);
while(parse.hasNext()) {
    if(parse.next().equals("stop"))
        prevClose = parse.nextDouble();
}

System.out.println(prevClose);