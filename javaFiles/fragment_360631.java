StringBuffer strbuf = new StringBuffer();
for(int i = 0; i<chalanList.size; i++)
{
     strbuf.append("1\n");
     strbuf.append("f_name: "+chalanList.get(i).f_name);
     strbuf.append(chalanList.get(i).getChalanNo());
     strbuf.append(chalanList.get(i).getBuyerName());
     . . .
}