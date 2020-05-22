// I'm assuming here is where you want it.

// description = new ArrayList<>(title.size());
String m = in.nextLine();
while(!m.equals(" ") && description.size() < title.size()){
    System.out.println("Enter the movie Description");
    description.add(m);
    m = in.nextLine();
}