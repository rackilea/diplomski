for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
    String fruit = iterator.next();
    if ("banane".equals(fruit)) {
        iterator.remove();
    }
    System.out.println(fruit);
}