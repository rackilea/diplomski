String MyString_temp = MyString;
String lookingFor = "S";
String separator = "\'";

boolean contains = false;
int indexOfLooking = -1;

while (MyString_temp.length() >= 0) {
   int first = MyString_temp.indexOf(separator);
   if(first == -1) {
       break;
   }
   int second = MyString_temp.substring(first + 1).indexOf(separator);
   second += first + 1;
   if(second == -1) {
       break;
   }
   indexOfLooking = MyString_temp.substring(first, second).indexOf(lookingFor);
   contains = (indexOfLooking >= 0)
   if (contains) {
      break;
   }
   MyString_temp = MyString_temp.substring(second + 1);
}