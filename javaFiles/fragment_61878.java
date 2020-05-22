String[] arr = {"Joe", "Jessica", "Javi", "James", "Kevin"};
List<String> names = Arrays.asList(arr);
for (Iterator<String> i = names.iterator(); i.hasNext(); ) {
    String str = i.next();
    System.out.print(str);
    System.out.println(",");
}