ArrayList<String> splitEquation = 
    new ArrayList<String>(Arrays.toList("5","*","5"));

for (i = 0; i < splitEquation.size(); i++){
    if (splitEquation.get(i).equals("*")) {
        splitEquation.set(i, 
            (Double.toString(Double.parseDouble(splitEquation.get(i - 1)) * 
                Double.parseDouble(splitEquation.get(i + 1))));
        splitEquation.remove(i - 1); // shortens array by 1
        splitEquation.remove(i); // this used to be (i + 1)
        i--; // move back one (your computed value)
        solution += Double.parseDouble(splitEquation.get(i));

    }
}