import java.util.regex.*; 

private static final int integer() {
    boolean invalid = true; 
    int number = 0; 
    while (invalid) { 
        String input = key.next(); 
        if (input.matches("\\d+")){ 
            invalid = false; 
            try { 
                number = Int.parseInt(input); 
            } catch (java.lang.NumberFormatException e) { 
                invalid = true; 
                System.out.print("Are you trying to break the program? Try again: "); 
            } 
        } else { 
            System.out.println("That's not a whole number! "); 
            System.out.print("Try again: "); 
        } 
    } 
    return number; 
}