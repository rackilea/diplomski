public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    System.out.println("Input ID you want remove: ");
    Scanner scanner = new Scanner(System.in);
    String inputId = scanner.nextLine();

    System.out.println("List before removing: " + list);

    for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
        String id = iterator.next();
        if (id.equals(inputId)) {
            iterator.remove();
            break;
        }
    }
    System.out.println("List after removing: " + list);
}