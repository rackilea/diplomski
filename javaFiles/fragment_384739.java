Scanner kbd = new Scanner(System.in);
System.out.println("Enter any String: ");
String myString = kbd.nextLine();
StringBuilder sb = new StringBuilder();
for (char ch : myString.toLowerCase().toCharArray()) {
    if (Character.isDigit(ch)) {
        sb.append(ch);
    }
}
int result = Integer.parseInt(sb.toString());
System.out.println("The result is " + result);