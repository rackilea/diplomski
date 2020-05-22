HashMap<Character, Integer> map = new HashMap<>();
map.put('a', 1);
map.put('b', 2);
map.put('c', 3);
map.put('d', 4);
map.put('e', 5);
// and so on...

String name = JOptionPane.showInputDialog(null,"Enter your name:");
char[] chars = name.toCharArray();
System.out.print("your name is: ");
for (char c : chars) {
    System.out.print(map.get(c));
    System.out.print(" ");
}