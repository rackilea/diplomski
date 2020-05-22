String data="book [new [interesting] book] buy it";
StringBuilder buffer=new StringBuilder();
int bracketCounter=0;
for (char c:data.toCharArray()){
    if (c=='[') bracketCounter++;
    if (c==']') bracketCounter--;
    if (c==' ' && bracketCounter==0)
        buffer.append("\n");
    else 
        buffer.append(c);
}
System.out.println(buffer);