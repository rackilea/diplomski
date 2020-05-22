public String toString() {
   StringBuilder builder = new StringBuilder();
   builder.append("My customized string.");
   builder.append(":");                                  // ***
   builder.append(Integer.toHexString(this.hashCode())); // ***
   return builder.toString();
}