try (Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build(); Session session = cluster.connect("test")) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter name1 ");
    String name1 = sc.nextLine();
    System.out.println("enter name2");
    String name2 = sc.nextLine();

    PreparedStatement queryStmt = session.prepare("select article_read from bat where name = ?");
    ResultSet result1 = session.execute(queryStmt.bind(name1));
    ResultSet result2 = session.execute(queryStmt.bind(name2));


    if (result1.one().getList("article_read", Integer.class).equals(result2.one().getList("article_read", Integer.class))) {
        System.out.println("100% sentiment ");
    } else {
        System.out.println("no sentiment ");
    }
}