FileReader f;
f=new FileReader("file.txt");
     BufferedReader b;
     b=new BufferedReader(f);
while(s=b.readLine()!=null){
     Matcher name=Pattern.compile("(?<=\\d\\.\\s)\\S+").matcher(s);   
     if(name.find())
           System.out.println(name.group());
 }