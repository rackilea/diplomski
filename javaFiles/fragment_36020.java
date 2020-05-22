boolean foundMark = false;
for (int count=0; count<name.length; count++) {
   if (secondmark==mark[count]) {
     System.out.println((name[count])+ " got the mark.");
     foundMark = true;
   }           
}

if(foundMark == false){
   System.out.println("Mark can't be found");
 }