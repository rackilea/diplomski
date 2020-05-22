final String regex1 = " (?=.*\\.(?=.*\\.))|(?<=\\.)(?=.*\\.)"
final String string = "Undersay v.To say by way of derogation or contradiction.";

String[] result=string.split(regex1);

for(String s:result) {
    System.out.println(s);
}