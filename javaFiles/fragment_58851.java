public class Assignment43StringInput {
  private static Scanner scanner = new Scanner( System.in );
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();

    System.out.print("Enter a subject: ");
    map.put("subject", scanner.nextLine());

    System.out.print("Enter a verb: ");
    map.put("verb", scanner.nextLine());

    System.out.print("Enter an adjective: ");
    map.put("adjective", scanner.nextLine());

    System.out.print("Enter an object: ");
    map.put("object", scanner.nextLine());

    System.out.print("Enter an adverb: ");
    map.put("adverb", scanner.nextLine());

    System.out.print(builder(map));
  }

  public static String builder(Map<String,String> map) {
    return map.get("subject") + " " + map.get("verb") + " " + map.get("adjective") + " " + map.get("object") + " " + map.get("adverb");
  }            
}