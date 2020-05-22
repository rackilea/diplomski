public static void main(String[] linesInFile) {
int numb = 200000;
DecimalFormat def = new DecimalFormat("#.00");
String finalnumb = def.format(numb / 100.0);
System.out.println(finalnumb);
}