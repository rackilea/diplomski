//Bug# 12544 start
    if(key.equals("orgId"))
    {
       criteria.add(Restrictions.eq("clientPK.orgId", searchParam.get(key)));
     }
        //Bug# 12544 End