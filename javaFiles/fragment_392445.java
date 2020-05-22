public class MyOwnClass {       // *** Not 'Stringbuilder'!!!

  public static void main(String[] args) {
    // Create a new StringBuilder
    StringBuilder builder = new StringBuilder(); // *** Not 'Stringbuilder' !!!

    // Loop and append values.
    for (int i = 0; i < 5; i++) {   // Use spaces properly      
      builder.append("abc");          
    }

    // Convert to string.
    String result = builder.toString();        
    System.out.println(result);
  }

}