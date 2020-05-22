//create array of 100 coordinate points

Point[] A = new Point[100];


Scanner in = new Scanner(System.in);

System.out.println("Enter index: ");

int i = in.nextInt(); //validate

System.out.print("Enter integers x, y to replace: ");

int x = in.nextInt();
int y = in.nextInt();

a[i] = new Point(x, y);