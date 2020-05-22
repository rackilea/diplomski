private void showRandomQuestionCat2() {

  Random rand = new Random();
  int index = rand.nextInt(list.size());
  String randomString = list.get(index);
  lb_randomCard.setText(randomString);
  list.remove(index);

 }