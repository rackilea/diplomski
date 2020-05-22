String input = "1 | 2 | 3 | [A] | B | C | [D] | C | [D] | C";
    System.out.println("initial input: " + input);
    input = input.replaceAll(" +\\[.*?\\] +\\|?",""); // remove [..] from the string
    System.out.println("filtered: " + input);
    String[] arr = input.split(" \\| "); // split the remaining parts into an array
    System.out.println("arr: " + Arrays.toString(arr));