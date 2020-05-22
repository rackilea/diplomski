String input = "1.fish.2.fish.red.sheep.blue.sheep";
Pattern animal = Pattern.compile("\\.*(fish|sheep)\\.*");
Scanner sc = new Scanner(input);

int endOfLastMatch = 0;
while (sc.hasNext()) {
    sc.useDelimiter(animal);
    String nextMatch = sc.next();

    int startOfCurrentMatch = sc.match().start(0);
    if (endOfLastMatch > 0) {
        System.out.println(new String(input.getBytes(), endOfLastMatch, startOfCurrentMatch - endOfLastMatch)); 
    }

    System.out.println(nextMatch);
    endOfLastMatch = sc.match().end();
}

if (endOfLastMatch < input.length()) {
    System.out.println(new String(input.getBytes(), endOfLastMatch, input.length() - endOfLastMatch));  
}