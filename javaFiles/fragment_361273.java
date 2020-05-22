public static void main(String[] args) {
                 Scanner input= new Scanner (System.in);
                  String result="";
                  System.out.println("Enter a number");
                   int num= input.nextInt();
                  String prim = "";

                  for (int i = 2; i <= num ; i++) {
                      int j=0;
                     while (num % i == 0) {
                        j++;
                        prim += i;
                        num /= i;
                     }
                   if(j>0){
                 if(j>1){
                   result=result+i+"^"+j+"*";
                 }else{
                     result=result+i+"*";
                 }
                }
                  }  


                  System.out.println("Prime factors are: " +result.substring(0,result.length()-1));

               }