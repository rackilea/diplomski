public class Grade {

public static void main(String[] arguments) {
    int grade = 69;
    if (grade >= 90) {
        System.out.println("Well done you got a A"); 
    } else if (grade >= 85) { 
        System.out.println("Well done you got a B");
    } else if (grade >= 75) {
        System.out.println("You got a C");
    } else if (grade >= 65) {
        System.out.println("You got a D");
    } else if (grade >= 55) {
        System.out.println("You got a E");
    }  else {
        System.out.println("You got a F");
    }
}
}