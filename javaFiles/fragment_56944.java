DBUser user3 = (DBUser) session.get(DBUser.class, 1);

if (user3 != null) {
    System.out.println(user3.getUsername());
} else {
    System.out.println("No user with given ID exists.");
}