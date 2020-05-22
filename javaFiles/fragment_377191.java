String[] sentence = new String("StackOverflow is a community of awesome programmers").split(" ");
    ArrayList<String> wordArray = new ArrayList<>();
    for (String word : sentence) {
       wordArray.add(0, word);
    }

    String backwards = String.join(" ", wordArray);
    System.out.println(backwards);