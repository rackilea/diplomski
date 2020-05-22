import java.util.Scanner;

public class Quadratic {

public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    boolean keepPlaying = true;
    while (keepPlaying) {
        System.out.print("\nax^2 + bx + c = 0");

        //input value of a.
        System.out.print("\n\na = ");
        int a = input.nextInt();

        //input value of b.
        System.out.print("b = ");
        int b = input.nextInt();

        //input value of c.
        System.out.print("c = ");
        int c = input.nextInt();

        System.out.print("\n");

        //output a-part of the equation.
        if (a != 0) {
            if (a == -1) {
                System.out.print("- ");
            } else if (a == 1) {
                System.out.print("");
            } else if (a < 0) {
                System.out.print("- " + Math.abs(a));
            } else if (a > 0) {
                System.out.print(a);
            }
            System.out.print("x^2 ");
        }
        //output b-part of the equation.
        if (b != 0) {
            if (b == -1) {
                System.out.print("- ");
            } else if (b == 1) {
                System.out.print("+ ");
            } else if (b < 0) {
                System.out.print("- " + Math.abs(b));
            } else if (b > 0) {
                System.out.print("+ " + b);
            }
            System.out.print("x ");
        }
        //output c-part of the equation.
        if (c != 0) {
            if (c < 0) {
                System.out.print("- " + Math.abs(c));
            } else if (c > 0) {
                System.out.print("+ " + c);
            }
        }
        //if everything is not zero.
        if (a != 0 && b != 0 && c != 0) {
            System.out.print(" = 0\n\n");
        }
        //if everything is zero.
        else if (a == 0 && b == 0 && c == 0) {
            System.out.print("0 + 0 + 0 = 0\n\n");
        }

        Quadratic quad = new Quadratic();
        quad.findAnswer(a, b, c);
        quad.additionalRoot(a, b, c);

        keepPlaying = quad.runAgain(input);
    }
}

//find the final answer.
private void findAnswer(int a, int b, int c) {
    if (findDiscriminant(a, b, c) < 0) {
        System.out.print("Imaginary Root");
    } else if (findDiscriminant(a, b, c) == 0) {
        System.out.print("One Twin Root");
        findTwoRoot(a, b, c);
    } else if (findDiscriminant(a, b, c) > 0) {
        System.out.print("Two Different Root");
        findTwoRoot(a, b, c);
    }
}

//find the discriminant of the quadratic-equation.
private int findDiscriminant(int a, int b, int c) {
    int discriminant = b * b - 4 * a * c;
    return discriminant;
}

//find the two root of the quadratic-equation.
private void findTwoRoot(int a, int b, int c) {
    double x1 = (-b + Math.sqrt(findDiscriminant(a, b, c))) / 2 * a;
    double x2 = (-b - Math.sqrt(findDiscriminant(a, b, c))) / 2 * a;

    if (x1 == x2) {
        System.out.print("\n\nx = " + x1);
    } else {
        System.out.print("\nx1 = " + x1 + "\nx2 = " + x2);
    }
}

//find the additional value by root.
private void additionalRoot(int a, int b, int c) {
    double addition = -b / a;
    System.out.print("\n\nX1 + X2 = " + addition);
    double multiplication = c / a;
    System.out.print("\nX1 * X2 = " + multiplication);
    double xp = -b / 2 * a;
    double yp = findDiscriminant(a, b, c) / -4 * a;
    System.out.print("\n\nCoordinate of the extreme value = (" + xp + ", " + yp + ")");
}

//see whether to rerun the main method.
private boolean runAgain(Scanner input) {

    System.out.print("\n\nAgain? (Y/N)\n");
    String repeat = input.next();
    return (repeat.equals("Y") || repeat.equals("y"));
}




}