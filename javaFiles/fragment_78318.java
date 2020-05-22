public static void main(String[] args) throws Exception {
        final List<String> list = new ArrayList<>(of("a", "b", "c"));
        final Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            final String value = iterator.next();
            iterator.remove();
            System.out.println("List: " + list + "\tRemoved: " + value);
        }
    }