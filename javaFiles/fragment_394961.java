int id1;
try {
    System.out.println("Enter id");
    id1 = Integer.parseInt(input.nextLine());
} catch (NumberFormatException e) {
    e.printStackTrace();
}
System.out.println("Enter name");
name1 = in.nextLine();