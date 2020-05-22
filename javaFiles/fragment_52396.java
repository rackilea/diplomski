public static TreeItem getTreeViewItem(TreeItem<String> item , String value) 
{
  if (item != null && item.getValue().equals(value))
    return  item;

  for (TreeItem<String> child : item.getChildren()){
   TreeItem<String> s=getTreeViewItem(child, value);
   if(s!=null)
       return s;

  }
  return null;
}