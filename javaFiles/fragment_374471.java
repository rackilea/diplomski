public static void parse (
       final List <NameValuePair> parameters, 
       final Scanner scanner, 
       final String encoding) {
   scanner.useDelimiter(PARAMETER_SEPARATOR);
   while (scanner.hasNext()) {
       final String[] nameValue = scanner.next().split(NAME_VALUE_SEPARATOR);
       if (nameValue.length == 0 || nameValue.length > 2)
           throw new IllegalArgumentException("bad parameter");

        final String name = decode(nameValue[0], encoding);
        String value = null;
       if (nameValue.length == 2)
           value = decode(nameValue[1], encoding);
       parameters.add(new BasicNameValuePair(name, value));
   }
}