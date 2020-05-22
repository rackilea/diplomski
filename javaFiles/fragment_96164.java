private ArrayList <String> deleteDuplicates() {
  ArrayList <Ping> tempPings = new ArrayList < Ping > ();
  tempPings.addAll(jaws.pastMonth());

  ArrayList <Ping> pingsToRemove = new ArrayList <Ping> ();
  for (int i = 0; i < tempPings.size(); i++) {
    Ping tempPing = tempPings.get(i);
    for (int j = i + 1; j < tempPings.size() - 1; j++) {
      Ping tempPing2 = tempPings.get(j);
      if (tempPing.getName().equals(tempPing2.getName())) {
        if (changePingToDate(tempPing2).before(changePingToDate(tempPing))) {

            pingsToRemove.add(tempPings.get(j));

        }
      }
    }
  }

  tempPings.removeAll(pingsToRemove);
  return pingToNames(tempPings);
}