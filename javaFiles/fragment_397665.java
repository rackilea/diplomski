ListIterator<String> iter = list.listIterator();
while (iter.hasNext()) {
    String s = iter.next();
    String dateNoTime = s.split(" ")[0];
    if(!dateNoTime.equalsIgnoreCase("2015-01-13")) {
        iter.remove();
    }
}