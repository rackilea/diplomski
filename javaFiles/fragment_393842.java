List<String> names = new ArrayList<>();
int count = 0;
for (int n = 1; n <= 10; n++) {
    System.out.println("Enter name");
    String name = input.nextLine();
     if (name.equals("ZZZ")) {
          break;
     }
     count = n;    
    names.add(name);
}

System.out.println(names);