// example, converts a collection of integers to their
// hexadecimal string representations
final Collection<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
final Collection<String> output =
    Collections2.transform(input, new Function<Integer, String>(){

        @Override
        public String apply(final Integer input){
            return Integer.toHexString(input.intValue());
        }
    });
System.out.println(output);