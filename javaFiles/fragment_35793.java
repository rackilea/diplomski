String[] sqls = new String[] {sql1, sql2, sql3, sql4};

for (int i = 0; i < 4; i++) {
    ALERTS.add(i, sqls[i]);
    System.out.println("ALERTS : " + ALERTS.get(i));

    csA = conn.prepareCall(ALERTS.get(i));
    csA.execute();
}