public static void main(String[] args) throws FileNotFoundException, IOException {
    List<String> xValues = new ArrayList<String>();
    List<String> yValues = new ArrayList<String>();
    List<String> zValues = new ArrayList<String>();
    //convert these lists of String to double yourself.

    xValues = readValuesFor("x");
    yValues = readValuesFor("y");
    zValues = readValuesFor("z");

    //print contents
    System.out.println("X values: ");
    for (final String x : xValues) {
        System.out.println(x);
    }

    System.out.println("Y values: ");
    for (final String y : yValues) {
        System.out.println(y);
    }

    System.out.println("Z values:");
    for (final String z : zValues) {
        System.out.println(z);
    }
}

public static List<String> readValuesFor(String variableName) throws FileNotFoundException, IOException {
    final List<String> result = new ArrayList<String>();
    final BufferedReader br = new BufferedReader(new FileReader("output.txt")); //change file name and path to yours
    String line;
    //read through file until you find a line that end with the variable x ,y, or z
    while ((line = br.readLine()) != null) {
        if (line.endsWith("for "+variableName.trim())) {
            break;
        }
    }

    if (!variableName.equals("z")) { //if variable is x or y
        while (!(line = br.readLine()).contains("Distribution")) {
            //read the lines between line ending in letters x or y and line containing word "Distribution"
            final String[] values = line.split(" "); 
            result.add(values[0]); //get the first value of the split
        }
    }
    else{
        while (!(line = br.readLine()).contains("Done")) { //if variable is z
            //read the lines between line ending with letter z and line containing word "Done"
            final String[] values = line.split(" ");
            result.add(values[0]); //get the first value of the split
        }
    }
    return result; //array with first values as string
}