String s = strings.remove(strings.size()-1);
// s is now equal to "o"
// strings is equal to ["h", "e", "l", "l"]
s += "C";
// s is now equal to "oC"
strings.add(s);
// strings is equal to ["h", "e", "l", "l", "oC"]