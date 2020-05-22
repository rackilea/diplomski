String checkWord = "c";
  String newWord = "";
  for (int i = 0; i < testList.size(); i++) {

    if (testList.get(i).equals(checkWord)) {
        newWord = "True";
        break;
    } else {
        newWord = checkWord;
    }
  }
  System.out.println(newWord);