String[] strings = new String[] { "red", "leaps", "dog" };
String[] literals = new String("The quick (red|brown|blue|yellow) fox " +
    "(jumps|leaps) over the lazy (dog|cat).").split("(?=[^\\\\])\\(.*?\\)");

StringBuilder sb = new StringBuilder(literals[0]);
for(int i = 0; i < strings.length; i++) {
    sb.append(strings[i]);
    sb.append(literals[i + 1]);
}

// => sb.toString();