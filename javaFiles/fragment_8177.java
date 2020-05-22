// Reading the input
BufferedReader reader = ... // And initialize the reader
ArrayList<String> input = new ArrayList<>();
while (reader.hasNextLine())
    input.add(reader.readLine());

// Storing the input
ArrayList<String> good = new ArrayList();
ArrayList<String> bad = new ArrayList();
for (String s : input) {
    sections = s.split(".");
    if (sections[sections.length - 1].equals("good"))
        good.add(s);
    else if (sections[sections.length - 1].equals("bad"))
        bad.add(s);
    else
        throw new IOException("Invalid filename.");
}

// Do whatever you want with the good and bad ArrayLists after this.
// If you want arrays, you can use ArrayList's toArray() method.