for (int i = 1; i < 4; i++) {
    System.out.println("Entered FOR LOOP!");
    cs1 = conn.prepareCall("sql" + i);
    System.out.println("sql" + i);
    cs1.execute();
}