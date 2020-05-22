public static void main(String[] args) {
    List<String> l = new LinkedList<>();
    for(int i=0; i < 100; i++) {
        l.add("banana"+i);
    }

    for (Iterator<String> iterator = l.iterator(); iterator.hasNext();) {
        String s = iterator.next();
        if("banana10".equals(s)) {
            iterator.remove();
        }
    }
}