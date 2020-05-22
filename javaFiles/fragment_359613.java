public class LargeInt{
   private String number;
   public LargeInt(String num){
      this.number = num;
   }

  public String add(String num2){
    Stack<Integer> adder = toIntegerStack(this.number);//UPDATE
    Stack<Integer> addend = toIntegerStack(num2);//UPDATE
    Stack<Integer> result = new Stack<Integer>();

    int carry =0;
    int tmp = 0;

  while(!.adder.isEmpty && !addend.isEmpty()){
   tmp = adder.pop()+addend.pop()+carry;
   if(tmp > 10){
     carry = tmp/10;
     tmp%=10;
   }else{
     carry=0;
   }
   result.push(tmp);
  }//while

  while(!adder.isEmpty){
    tmp = adder.pop()+carry;
    if(tmp > 10){
     carry = tmp/10;
     tmp%=10;
   }else{
     carry=0;
   }
   result.push(tmp);
  }//while

  while(!addend.isEmpty){
    tmp = addend.pop()+carry;
    if(tmp > 10){
     carry = tmp/10;
     tmp%=10;
   }else{
     carry=0;
   }
   result.push(tmp);
 }//while

//beyond this point the result is your answer
//here convert your stack to string before returning
}
}