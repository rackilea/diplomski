static String[] braces(String[] values) {
    Stack<Character> st = new Stack<Character>();
     String []answer = new String[values.length];
     Boolean isCorrect = false;

    for(int i =0; i< values.length;i++)
     {
         isCorrect = true;
        st.clear();
         char crt[] = values[i].toCharArray();

        for(char c : crt)
         { 
             switch(c)
             {
             case'{':
             case'[':
             case'(':
                 st.push(c);
                 break;

                 case'}':
                 if(st.isEmpty() || st.peek() != '{')
                 {
                     System.out.println("Hellooo");
                     answer[i] ="NO";
                     isCorrect = false;
                 }
                 if(!st.isEmpty()) 
                 {
                    st.pop();
                 }
                 break;

                 case']':
                 if(st.isEmpty() || st.peek() != '[')
                 { 
                     System.out.println("Hell");
                     answer[i] ="NO";
                     isCorrect = false;
                 }
                 if(!st.isEmpty()) 
                 {
                     st.pop();
                }

                 break;

                case')':
                 if(st.isEmpty() || st.peek() != '(')
                 {
                     isCorrect = false;
                 }

                 if(!st.isEmpty()) {

                     st.pop();

                     }

                 break;
             }
         }

         if(isCorrect && st.isEmpty())

         {
             answer[i] = "YES";
             System.out.println("Hello");
         }else answer[i] = "NO";
     }
    return answer;
}