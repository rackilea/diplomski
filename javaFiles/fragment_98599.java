QueueOrStack<String> strings = new QueueOrStack<>(true);
strings.pushAll("hello", ", " , "world\n");
for(String s : strings)
    System.out.print(s); //"hello, world"
System.out.println(strings.pop()); //"hello"
strings.toggleQueue();
System.out.println(strings.pop()); //"world"