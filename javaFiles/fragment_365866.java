ArrayList<String> s = new ArrayList<>();
s.add("hello");
// add more Strings...

ArrayList<String> rem = new ArrayList<>();
rem.add("hello");
// add more Strings to remove...

for (int i = s.size() - 1; i >= 0; i++) {
    if (rem.contains(s.get(i)) {
        s.remove(i);
    }
}