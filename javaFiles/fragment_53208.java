Iterator<YourThing> firstIt = firstList.iterator();
while (firstIt.hasNext()) {
  String str1 = (String) firstIt.next().ID();
  // recreate iterator for second list
  Iterator<YourThing> secondIt = secondList.iterator();
  while (secondIt.hasNext()) {
    String str2 = (String) secondIt.next().ID();
    if (str1.equals(str2)) {
      //do sth
    }
  }
}