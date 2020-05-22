public static void main(String[] args) {
      String strlist =
            "[1,2,113],     [4,5,[5,2,10],1], [],[1,2,3,4,5,[10,11,12,13,[14,15]]]";
      int bracketCount = 0;
      int num = 0;

      // inital list
      List<Object> list = new ArrayList<>();

      // hold sublists for precessing
      Stack<List<Object>> stack = new Stack<>();

      char[] chars = strlist.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         char c = chars[i];
         switch (c) {
            // state1 left bracket - push current list on stack for later
            // retrieval
            // allocate new list and add it to one just pushed (remember,
            // I still have its reference).
            // Assign nlist to list
            // increment bracket count
            case '[':
               stack.push(list);
               List<Object> nlist = new ArrayList<>();
               list.add(nlist);
               list = nlist;
               bracketCount++;
               break;
            // state2 right bracket - Finished processing current sublist.
            // if previous tokens were not brackets, then add the
            // number to the list and pop off the previous one.
            // decrement bracket count
            case ']':
               if (chars[i - 1] != '[' && chars[i - 1] != ']') {
                  list.add(num);
               }
               list = stack.pop();
               bracketCount--;
               break;
            // state3 - whitespace - ignore
            case ' ':
            case '\t':
               break;
            // state4 comma - if previous token was not a right bracket,
            // then add number. Reset num for next number.
            case ',':
               if (chars[i - 1] != ']') {
                  list.add(num);
               }
               num = 0;
               break;
            // state5 digit - assumed to be a digit. Each time a digit
            // is encountered, update the number
            default:
               num = num * 10 + c - '0';
         }
         if (bracketCount < 0) {
            System.out.println("too many ] brackets at location " + i);
         }
      }
      if (bracketCount > 0) {
         System.out.println("insufficent number of ] brackets");
      }
      System.out.println(list);
   }
}