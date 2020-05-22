public static String describeArguments (Object... arguments) {
   StringBuilder output = new StringBuilder();
   int counter = 1;
   for (Object argument : arguments) {
      output.append("object #").append(counter++).append(": ").append(argument.toString());
   }
   return output.toString();
}