//1. initiate the string you want to shuffle
    String originalString = "pumkinpie";
    //2. initiate a List into which the characters will be added
    List<Character> characterList= new ArrayList<Character>();
    //3. add each character from the String to the List
    for (char character : originalString.toCharArray()) {
        characterList.add(character);
    };
    //4. shuffle using Collections.shuffle
    Collections.shuffle(characterList, new Random());
    //5. print each character
    for (Character character : characterList) {
        System.out.println(character);
    }