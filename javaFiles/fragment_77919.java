private static String REGEX = "dog";
private static String INPUT = "The dog says meow. ";
private static String REPLACE = "cat";

public static void main(String[] args) {
   Pattern p = Pattern.compile(REGEX);
   // get a matcher object
   Matcher m = p.matcher(INPUT); 
   INPUT = m.replaceAll(REPLACE).replace("meow", "bow");
   System.out.println(INPUT);