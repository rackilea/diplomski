ModelMap [] rowMap = new  ModelMap()[3];
for (int i=0;i<3;i++)
{
  ModelMap this_row=new ModelMap();
  this_row.put("id",i);
  this_row.put("name","name"+i);
  rowMap(i)=this_row;
}
modelMap.put("rows",rowMap);