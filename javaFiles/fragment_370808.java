String string1 = "abab";
Pattern p = Pattern.compile("ab");
Matcher m = p.matcher(string1);
int count = 0;
while (m.find()){
    count +=1;
}
System.out.println(count);