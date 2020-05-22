public class FindArea {
        // side is only input provided to cube. Area of the cube is returned
        public static double cube(double side) {
            double Area;
            return Area = 6 * side * side;
        }

        // radius is only input provided to sphere. Area of the sphere is returned
        public static double sphere(double radius) {
            double Area;
            return Area = 4 * 3.14 * radius * radius;
        }

        // radius and height are the only inputs provided to cylinder.
        // Area of the cylinder is returned
        public static double cylinder(double radius, double height) {
            double Area;
            return Area = 2 * 3.14 * radius * height + 2 * 3.14 * radius * radius;
        }

        // outerR and innerR are the only inputs provided to doughnut.
        // Area of the doughnut is returned
        public static double doughnut(double outerR, double innerR) {
            double Area;
            return Area = (2 * 3.14 * innerR) * (2 * 3.14 * outerR);
        }

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            System.out
                    .println("Enter 1 for Cube, 2 for Sphere, 3 for Cylinder, 4 for Doughnut, Or enter 0 to exit ");



            int n = 0;
            double side = 0;
            double Area = 0;
            double radius = 0;
            double height = 0;

            n = input.nextInt();
            switch (n) {

            case 0:
        System.out.println("Exit");
        System.exit(1);
        break;
            case 1:
                System.out.print("Enter side measurement of cube: ");
                side = input.nextDouble();
                Area = cube(side);
                System.out.println("The area of the cube is: " + Area);
                break;

            case 2:
                System.out.print("Enter radius measurement of sphere: ");
                radius = input.nextDouble();
                Area = sphere(radius);
                System.out.println("The area of the sphere is: " + Area);
                break;

            case 3:
                System.out.print("Enter radius measurement of cylinder: ");
                radius = input.nextDouble();
                System.out.print("Enter height measurement of cylinder: ");
                height = input.nextDouble();
                Area = cylinder(radius, height);
                System.out.println("The area of the cylinder is: " + Area);
                break;

            case 4:
                System.out.print("Enter inner radius: ");
                double innerR = input.nextDouble();
                System.out.print("Enter outer radius: ");
                double outerR = input.nextDouble();
                Area = doughnut(outerR, innerR);
                System.out.println("The area of the donut is: " + Area);
                break;

            default:
                System.out.println("--------");
                System.out.println("Invalid option selected");
                System.out.println("--------");
                System.out
                        .println("Enter 1 for Cube, 2 for Sphere, 3 for Cylinder, 4 for Doughnut");
                System.out.println("Or enter 0 to exit");
                n = input.nextInt();
                break;
            }
        }
    }