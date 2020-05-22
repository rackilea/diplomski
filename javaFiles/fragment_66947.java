Scanner sc = new Scanner(System.in);
Pattern newlineOrSpace = Pattern.compile(System
        .getProperty("line.separator") + "|\\s");
sc.useDelimiter(newlineOrSpace);
System.out.print("Enter a, b, c: ");
double a = sc.nextDouble();
double b = sc.nextDouble();
double c = sc.nextDouble();
System.out.format("a = %f, b = %f, c = %f", a, b, c);