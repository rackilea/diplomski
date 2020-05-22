public String toString() {
   StringBuilder builder = new StringBuilder();
   builder.append("My customized string.");
   builder.append(":");              // ***
   builder.append(super.toString()); // ***
   return builder.toString();
}