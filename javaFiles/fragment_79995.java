String name = "eric";
char[] nameForYou = name.replaceAll(".","*").toCharArray();
System.out.println("Guess my name: "+new String(nameForYou)+" "+name.length());
String yourguess = "c";
for (int i=0;i<name.length();i++) {
    if ((yourguess.charAt(0) == name.charAt(i))){
        nameForYou[i] = yourguess.charAt(0);
    }
}
System.out.println(new String(nameForYou));