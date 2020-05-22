class Member {
  private String name;
  private int age;
  public Member(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }
}


public static void main(String[] args) {
  System.out.println("Please enter a name you would like to search for: ");
  String search = user_input.next();
  List<Member> list = Arrays.asList(
         new Member("gary", 25), 
         new Member("anotherGuy", 25));

  if(list.stream().anyMatch(m -> search.equals(m.getName()))) {
    System.out.println("Match");
  } else {
    System.out.println("Fail");
  }
}