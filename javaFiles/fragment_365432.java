List<Friend> friends = new ArrayList<>();
Scanner scan = new Scanner(System.in);

System.out.print("Enter How Many Friends : ");
int many = scan.nextInt();

for (int i = 0; i < many; i++) {
    System.out.print("Friend Of-" + (i + 1) + " : ");
    String firstName = scan.next();
    String lastName = scan.next();
    friends.add(new Friend(i + 1, firstName, lastName));
}

scan.close();

System.out.println("\nInitials: ");
for (Friend friend : friends)
    System.out.println(String.format("%d. %s", friend.id, friend.getInitials()));

System.out.println("\n4 Letterhead: ");
for (Friend friend : friends)
    System.out.println(String.format("%d. %s", friend.id, friend.getLetterHead()));

System.out.println("\nFirst Name: ");
for (Friend friend : friends)
    System.out.println(String.format("%d. %s", friend.id, friend.firstName));

System.out.println("\nLast Name: ");
for (Friend friend : friends)
    System.out.println(String.format("%d. %s", friend.id, friend.lastName));
    }
}