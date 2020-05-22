private static void parseDoubleArrayFromInput (String[] input, double[] parsedDoubles){
    // process all of the input
    for(int i = 0 ; i < input.length; i++) {
        // remove from the input things that will break the parsing
        // NOTE: other approaches could be used to ensure there is 
        //   only a single ".".
        // NOTE: assumes the input to be US standard, as other approachs
        //        might use a "," for separator
        String clean = input[i].replaceAll("[^0-9.]", "");

        // put the result
        parsedDoubles[i] = Double.parseDouble(clean);
    }
}