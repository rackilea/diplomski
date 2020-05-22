boolean records = false;
while(rs.next()) {
    records = true;
    // code
}
if(!records)
    GUI.NoResults();