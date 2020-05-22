Path path = FileSystems.getDefault().getPath("jedis.txt");
List<String> list = loadList(path);

try(Scanner sc = new Scanner(System.in)){
   String[] input = sc.nextLine().split(" ");
   while(input.length > 0 && !input[0].equals("exit")){
      switch(input[0]){
         case "add" : addToList(input, list); break;
         case "show": showList(input, list); break;
      }
      input = sc.nextLine().split(" ");
   }
}

saveList(path, list);