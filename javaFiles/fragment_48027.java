// assume String
Iterator<String> it = arrayListWords.iterator();
if (it.hasNext()) {
    System.out.print(it.next());
}
while (it.hasNext()) {
    System.out.print(", " + it.next());
}