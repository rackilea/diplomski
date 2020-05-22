Hashtable<Character, List<Boolean>> charCheck = new Hashtable<Character, List<Boolean>>();
char[] charArray = str.toCharArray(); 

for (char c : charArray) {
    List<Boolean> used = charCheck.get(c);

    // If the char isn't in the map yet, add a new list
    if (used == null) {
        used = new ArrayList<Boolean>();
        charCheck.put (c, used);
    }

    used.add(false);
}