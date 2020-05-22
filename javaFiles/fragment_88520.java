long t0 = System.nanoTime();
conn.setAutoCommit(false);

String sql = null;
Statement st = conn.createStatement();
st.execute("CREATE TEMPORARY TABLE tmp (CandidateID INT, result VARCHAR(255), score INT, uploadState VARCHAR(255))");
sql = "INSERT INTO tmp (result, score, uploadState, CandidateID) VALUES (?,?,?,?)";
PreparedStatement ps = conn.prepareStatement(sql);
String tag = "Y";
for (int i = 1; i <= 10000; i++) {
    ps.setString(1, String.format("result_%s_%d", tag, i));
    ps.setInt(2, 400000 + i);
    ps.setString(3, String.format("state_%s_%d", tag, i));
    ps.setInt(4, i);
    ps.addBatch();
}
ps.executeBatch();
sql = 
          "UPDATE personal_info pi INNER JOIN tmp ON tmp.CandidateID=pi.CandidateID "
        + "SET pi.result=tmp.result, pi.score=tmp.score, pi.uploadState=tmp.uploadState";
st.execute(sql);
conn.commit();
System.out.printf("%d ms%n", (System.nanoTime() - t0) / 1000000);