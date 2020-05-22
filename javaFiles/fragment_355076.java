Scanner a = new Scanner (System.in);
System.out.print("Enter string: ");
String s = a.nextLine();
String res = "";
for (char c : s.toCharArray())
{
    if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
        res = res + '_';
    }
    else
        res = res + c;
}
System.out.println(res); //Will contain the string with the vowels replaced with _