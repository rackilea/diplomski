String s = "001>10102011>874837>Y>Y>TEST001>No\\\\002>11102011>8743834>Y>Y>null>No\\\\";
String[] rows = s.split("\\\\");
for (String r : rows) {
    String[] cols = r.split(">");
    for (String c : cols) {
        System.out.print(c + "\t");
    }
    System.out.println();
}