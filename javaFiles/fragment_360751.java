int number = 1234;

   //convert int to a list
   List<String> list = Arrays.asList(String.valueOf(number).split(""));

   //add 3 to each elements of the list and derive a String list as the result
   List<String> listContain3 = list.stream()
                                   .map( i -> "3"+i)
                                   .collect(Collectors.toList());

   //add all elements of the list together and convert it to the int 
   int result =  Integer.parseInt(String.join("", listContain3));

   System.out.println(result);