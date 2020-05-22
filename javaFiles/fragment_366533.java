String queryStr = "select p from Person p";
int count=0;
for(String str:names) {
   if(count==0) queryStr+="WHERE p.name LIKE :name"+count;
   else queryStr+=" AND p.name LIKE :name"+count;
   count++;
}
... Initialize query
for(String str:names) {
... Set all the :name+count as parameters
}