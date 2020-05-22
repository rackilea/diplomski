String regex = "[1-7]";
int max = 0;
int number;

for (Object obj : objectList){
  if(obj.status().matches(regex)){
      number = Integer.valueOf(obj.status());
      if(number > max){
        max=number;
     }
  }
}
if(max==0){
  System.out.println("XYZ");} 
else{
  System.out.println(String.valueOf(max));
}