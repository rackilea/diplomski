List<Player> list1 = new ArrayList<>(); // list1 contains new object instance A
List<Player> list2 = new ArrayList<>(); // list2 contains new object instance B
Player player = new Player(); // player contains new object instance C
list1.add(player);
list2.add(player);
player.setPoints(13); // Changed in both lists.

List<Player> list1 = new ArrayList<>(); // list1 contains new object instance A
List<Player> list2 = list1; // list2 contains object instance A
list2.add(player);
list1.add(player);
// instance A now holds 2 Players (the same one).
assert list1.size() == 2;
assert list2.size() == 2;

List<Player> list1 = new ArrayList<>(); // list1 contains new object instance A
list1.add(player);
list1.add(player);
list1.add(player);
List<Player> list2 = list1.subList(1, 2); // list2 contains new object instance B
// But a subList is a list backed by the original list.
Player player2 = new Player();
list1.set(1, player2); // list2.get(1) == player2
Player player3 = new Player();
list2.set(1, player3); // list1.get(1) == player3