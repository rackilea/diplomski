private static HashMap<Integer, Object> shapes = 
                                              new HashMap<Integer, Object>();
        static int i = 0;

        public static void main(String[] args) {
            PrintWriter output = null;
            Scanner scanner = new Scanner(System.in);
            try {
                output = new PrintWriter(new FileWriter("output.txt"), true);
            } catch (IOException e1) {
                System.err.println("You don't have accress to this file");
                System.exit(1);
            }
            String command = "";
            while(!"quit".equalsIgnoreCase(command)){
                System.out.println("Enter your Command: ");
                command = scanner.next();
                if (command.equalsIgnoreCase("create")) {
                    String type = scanner.next();
                    if (type.equalsIgnoreCase("line")) {
                        double length = scanner.nextDouble();
                        Line l = new Line(length);
                        scanner.nextLine();//flush the previous line
                        String line = scanner.nextLine();
                        output.format("%s", line);
                        shapes.put(i, l);
                        i++;
                    }else if (type.equalsIgnoreCase("circle")) {
                        double radius = scanner.nextDouble();
                        String color = scanner.next();
                        Circle c = new Circle(radius, Colors.valueOf(color));
                        scanner.nextLine();//flush the previous line
                        String line = scanner.nextLine();
                        output.format("%s", line);
                        shapes.put(i, c);
                        i++;
                    }else if (type.equals("rectangle")) {
                        double length = scanner.nextDouble();
                        double width = scanner.nextDouble();
                        String color = scanner.next();
                        Rectangle r = new Rectangle(length, width,
                        Colors.valueOf(color));
                        scanner.nextLine();//flush the previous line
                        String line = scanner.nextLine();
                        output.format("%s", line);
                        shapes.put(i, r);
                        i++;
                    }else if (type.equals("square")) {
                        double length = scanner.nextDouble();
                        String color = scanner.next();
                        Square s = new Square(length, Colors.valueOf(color));
                        scanner.nextLine();//flush the previous line
                        String line = scanner.nextLine();
                        output.format("%s", line);
                        shapes.put(i, s);
                        i++;
                    }
                }else if (command.equals("printbyperimeter")) {
                    Shape[] shapeArray = shapes.values().toArray(new Shape[0]);
                    Arrays.sort(shapeArray);
                            System.out.println("Print in ascending order...");
                    for (int j = 0; j < shapeArray.length; j++) {
                        Shape temp = shapeArray[j];
                        if (temp.getClass().getName().equals("Line")) {
                            System.out.println("Shape: " 
                                    + temp.getClass().getName() + ", Perimeter: "
                                    + temp.getPerimeter());
                                } else {
                            System.out.println("Shape: " 
                                    + temp.getClass().getName() + ", Color: "
                                    + ((Colorable) temp).getColor()
                                    + ", Perimeter: " + temp.getPerimeter());
                                }
                            }
                }else if (command.equals("printbyarea")) {
                    Shape[] shapeArray = shapes.values().toArray(new Shape[0]);
                    System.out.println("Print in random order...");
                    for (int j = 0; j < shapeArray.length; j++) {
                        Shape temp = shapeArray[j];
                        if (!temp.getClass().getName().equals("Line")) {
                            System.out.println("Shape: "
                                    + temp.getClass().getName() + ", Color: "
                                    + ((Colorable) temp).getColor() + ", Area: "
                                    + ((Areable) temp).getArea());
                                }
                        }
                }else if (command.equals("quit")) {
                    scanner.close();
                    System.exit(0);
                }
           }
           output.close();
        }