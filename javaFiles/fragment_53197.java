PreparedStatement ps = conn.prepareStatement(sql);
int count = 0;
for(loop construct here) {
    count++;
    ps.setString(1,someString);
    // ... and so forth
    ps.addBatch();

    if (count%500 ==0)
        ps.executeBatch()
}
ps.executeBatch();