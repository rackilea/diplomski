Iterator<String> iterator = list.iterator();
while (i.hasNext()) {
    if ("foo".equals(i.next())) {
        i.remove();
        break;
    }
}
// lots more code