static boolean isOperator(char ch){
     return ch=='+' || ch=='-' || ch=='/' || ch=='*';
   }

   static boolean precedence(Character a,Character b){
     switch(a){
         case '+': return !(b=='-') || !(b=='*') || (b=='+') || !(b=='/');
        default : return false;
     }
   }

  static public void main(String... args){
       String filename="king.txt";
       StringBuffer sb=new StringBuffer();
       try{
             java.util.Scanner sc=new java.util.Scanner(new java.io.File(filename));
             while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   System.out.println(s);
                   java.util.Stack<Character> stack=new java.util.Stack<Character>();
                   String[] st=s.split("\\s");
                   for(String ss:st){
                         char ch=ss.charAt(0);
                         if(isOperator(ch)){
                               switch(ch){
                                     case '+': if (!stack.empty() && stack.peek().toString().charAt(0)=='+')
                                           stack.pop();
                                           else stack.push(ch);
                                           break;
                                     case '-': if (!stack.empty() && stack.peek().toString().charAt(0)=='-')
                                           stack.pop();
                                           else stack.push(ch);
                                           break;
                                     case '*': if (!stack.empty() && stack.peek().toString().charAt(0)=='*')
                                           stack.pop();
                                           else stack.push(ch);
                                           break;
                                     case '/': if (!stack.empty() && stack.peek().toString().charAt(0)=='/')
                                           stack.pop();
                                           else stack.push(ch);
                                           break;        
                               }
                         }else sb.append(ss);
                   }
                   order(stack);
                     for(;!stack.empty();sb.append(stack.pop()));
                        System.out.println(sb.toString());


             }
       }catch(Exception e){ e.printStackTrace();}        

  }
  static Stack<Character> order(Stack<Character> stack) {
      for(int i = 0; i < stack.size()-1; i++) {
          if(!precedence(stack.elementAt(i), stack.elementAt(i+1))) {
              Character temp = stack.pop();
              Character temp2 = stack.pop();
              stack.push(temp);
              stack.push(temp2);

          }
      }
      return stack;
  }