Scanner sc = new Scanner(System.in);
    StringBuffer result = new StringBuffer();
    System.out.println("enter the string");
    String name = sc.nextLine();
    String[] words = name.split("\\s");
    for (int i = 0; i < words.length; i++) {
        String med = words[i];

        for (int j = 0; j < med.length(); j++) {
            if (j % 2 == 0) {
                result.append(Character.toUpperCase(words[i].charAt(j)));
            } else {
                result.append(Character.toLowerCase(words[i].charAt(j)));

            }
        }
        result.append(" ");
    }
    System.out.println(result);