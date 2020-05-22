CountedString {
   char[] string;
   int length;

   int getLength() {
     return length;
   }
}


TerminatedString {
   char[] string;
   final static char TERMINATOR = '$';
   int getLength() {
     for (int i = 0; i < string.length; i++) {
        if (string[i] == TERMINATOR) return i;
     }
   }
}