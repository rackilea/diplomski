long t0 = System.nanoTime();
conn.setAutoCommit(false);

String sql = null;
sql = "UPDATE personal_info SET result=?, score=?, uploadState=? WHERE CandidateID=?";
PreparedStatement ps = conn.prepareStatement(sql);
String tag = "X";
for (int i = 1; i <= 10000; i++) {
    ps.setString(1, String.format("result_%s_%d", tag, i));
    ps.setInt(2, 200000 + i);
    ps.setString(3, String.format("state_%s_%d", tag, i));
    ps.setInt(4, i);
    ps.addBatch();
}
ps.executeBatch();
conn.commit();
System.out.printf("%d ms%n", (System.nanoTime() - t0) / 1000000);