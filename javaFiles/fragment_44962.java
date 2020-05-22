String[] elements = xml.split("<");
LinkedList<String> ll = new LinkedList<String>();
for (String str : elements) {
    if (str.isEmpty())
        continue;
    str = str.trim();
    if (ll.isEmpty()) {
        ll.add(str);
        continue;
    }
    if (!ll.peekLast().equals(str)) {
        ll.add(str);
    }
}
while (!ll.isEmpty()) {
    System.out.println("<" + ll.pollFirst());
}