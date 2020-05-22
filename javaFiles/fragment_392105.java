ArrayList<Output> list=new ArrayList<Output>();
int i=-1; Output op =null;
while (scanner.hasNextLine()) {
     String line = scanner.nextLine();i = ++i%3;
     if(i==0){
        op = new Output();
        op.setStr1(line);
     }else if(i==1)
        op.setStr2(line);
     else
        op.setStr3(line);
}