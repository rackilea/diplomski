ArrayList<String> flags = new ArrayList<>();
ArrayList<String> words = new ArrayList<>();
ArrayList<String> files = new ArrayList<>();
for (String arg : args) {
    if (arg.equals("--")) {
        continue;
    }
    if (arg.contains(".")) {
        files.add(arg);
    }else if (arg.contains("-")) {
        flags.add(arg);
    }else {
        words.add(arg);
    }
}