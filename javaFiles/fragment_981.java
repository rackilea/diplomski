Scanner klavye = new Scanner(System.in);
String tokens[] = klavye.nextLine().split(" ");
while(tokens.length < 2) { 
    System.out.println("Bad line, enter again:");
    tokens = klavye.nextLine().split(" ");
}
char karakter = tokens[0].charAt(0);
System.out.println("karakter = " + karakter);
int sayi = Integer.valueOf(tokens[1]);
System.out.println("sayi = " + sayi);