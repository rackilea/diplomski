String data="300x250,468x60,300x400v(480x320,768x1024,100x100),400x300v,640x480v(200x200,728x90)";

List<String> tokens=new ArrayList<>();
StringBuilder buffer=new StringBuilder();

int parenthesesCounter=0;

for (char c : data.toCharArray()){
    if (c=='(') parenthesesCounter++;
    if (c==')') parenthesesCounter--;
    if (c==',' && parenthesesCounter==0){
        //lets add token inside buffer to our tokens
        tokens.add(buffer.toString());
        //now we need to clear buffer  
        buffer.delete(0, buffer.length());
    }
    else 
        buffer.append(c);
}
//lets not forget about part after last comma
tokens.add(buffer.toString());

String[] splitedArray=tokens.toArray(new String[tokens.size()]);

//lets test what is inside our array
for (String s : splitedArray)
    System.out.println(s);