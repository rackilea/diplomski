Scanner scnr = new Scanner(System.in);
String str = scnr.nextLine();
String reverse = "";

for (int i=str.length()-1; i >= 0; i=i-3) {
    reverse += str.charAt(i);
}

System.out.println(reverse);