ArrayList<Hotell> elements = new ArrayList<Hotell>(); //Your list
String id = keyboard.nextLine();
Optional<String> element = elements.stream()
        .filter(e -> e.get_Idset().equals(id))
        .findFirst();
if(element.isPresent()){
    System.out.println("Element found");
}else{
    System.out.println("Element not found");
}