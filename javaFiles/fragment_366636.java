int lines = Integer.parseInt(sc.nextLine());
double a;
double b;
double c;

String line = "";
Scanner abc = new Scanner(line);
for (int count = 0; count < lines; count++) {
    line = sc.nextLine();
    abc = new Scanner(line);

    a = Double.parseDouble(readNextAndLog(abc));
    b = Double.parseDouble(readNextAndLog(abc));
    c = Double.parseDouble(readNextAndLog(abc));
}