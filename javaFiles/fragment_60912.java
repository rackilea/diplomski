OracleConnection connection = uploadCall.getJdbcTemplate().getDataSource().getConnection().unwrap(OracleConnection.class);
StructDescriptor desc1=StructDescriptor.createDescriptor("XX_TYP",connection);
ArrayDescriptor desc2=ArrayDescriptor.createDescriptor("XX_TAB",connection);
Object[] p1arrobj = new Object [uploadList.size()];
for(int i=0;i<orderList.size();i++)
{
    Object [] p1recobj = {orderList.get(i).getId(),orderList.get(i).getType()};
    STRUCT p1struct = new STRUCT(desc1,connection,p1recobj);
    p1arrobj[i]=p1struct;
}
ARRAY p1arr = new ARRAY(desc2,connection,p1arrobj);