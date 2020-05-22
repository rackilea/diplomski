List<Integer> out=new ArrayList<Integer>();
String numbers[]=s.split(",");
for(String part:numbers){
    if(part.contains("-"){
        int a=Integer.parseInt(part.split("-")[0]);
        int b=Integer.parseInt(part.split("-")[1]);
        while(a<=b){
             out.add(a++);
        }
    }else{
        out.add(Integer.parseInt(part));
    }
}