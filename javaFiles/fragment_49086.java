ArrayList<Integer> numberList1 = new ArrayList<Integer>();
    ArrayList<Integer> numberList2 = new ArrayList<Integer>();
    ArrayList<Integer> outputList = new ArrayList<Integer>();

    String str1 = "abc 11:4 xyz 10:9";
    String str2 = "abc 9:2  xyz 100:11";

    String output = "";

    // Extracting numbers from the two similar string
    Pattern p1 = Pattern.compile("-?\\d+");

    Matcher m = p1.matcher(str1);
    while (m.find()) {
        numberList1.add(Integer.valueOf(m.group()));
    }

    m = p1.matcher(str2);
    while (m.find()) {
        numberList2.add(Integer.valueOf(m.group()));
    }

    // Numbers extracted. Printing them
    System.out.println("List1: " + numberList1);
    System.out.println("List2: " + numberList2);

    // Adding the respective indexed numbers from both the lists
    for (int i = 0; i < numberList1.size(); i++) {
        outputList.add(numberList1.get(i) + numberList2.get(i));
    }

    // Printing the summed list
    System.out.println("Output List: " + outputList);

    // Splitting string to segregate numbers from text and getting the format
    String[] template = str1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

    // building the string back using the summed list and format
    int counter = 0;
    for (String tmp : template) {
        if (Test.isInteger(tmp)) {
            output += outputList.get(counter);
            counter++;
        } else {
            output += tmp;
        }
    }

    // Printing the output
    System.out.println(output);
}

public static boolean isInteger(String s) {
    try {
        Integer.parseInt(s);
    } catch (NumberFormatException e) {
        return false;
    }
    return true;
}