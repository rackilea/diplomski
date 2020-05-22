Object[] skuid=new Object[product_list.size()];
Object calling[]=new Object[product_list.size()];

for(int m=0;m<product_list.size();m++)
{
    skuid[m]=new Object[]{product_list.get(m).getp_Sku()};
    calling[m]=new Object[]{"catalog_product_attribute_media.list",skuid[m]};   
}

try 
{
  client.callEx("multiCall",new Object[]{Utils.sessionId,calling});
}
catch (XMLRPCException e) 
{
    e.printStackTrace();
}