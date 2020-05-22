String input = "hello 12345\n";
Scanner s = new Scanner(input);

while(s.hasNext()){
    System.out.println(s.next());
}
//Outputs: Hello
//         12345