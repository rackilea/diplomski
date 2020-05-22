while(rs.next())
{
        obj = new JSONObject();
        vname=rs.getString ("vlgname");
        vcode=rs.getString("vlgcode");
        divsec=rs.getString("divsec");
        obj.put("vname",vname);
        obj.put("vcode",vcode);
        obj.put("divsec",divsec);
        list.add(obj);
}
obj2.accumulate("get", list);
out.println(obj2);