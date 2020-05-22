while(rSet.next()) {
    int j=0;
    l.get(j).setF_id(rSet.getInt("f_id"));
    l.get(j).setF_name(rSet.getString("f_name"));
    j++;
}