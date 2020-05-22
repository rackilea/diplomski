try
{
        String sql1 = "UPDATE db_table Set score = score + " + String.valueOf(reg);
        pst = con.prepareStatement(sql1);
        rs = pst.executeQuery();
}