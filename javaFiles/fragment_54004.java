ArrayList<ListItem> list=new ArrayList<ListItem>();
String[] contents=cwFile.list();
for(int i=0;i<contents.length;i++){
    ListItem curItem=new ListItem();
    curItem.itemName = contents[i];
    if(new File(cwd+contents[i]).isDirectory()){
        curItem.isDir=true;
    }
    list.add(i,curItem);
}
Log.i("Main",list.get(0).itemName);
Log.i("Main",contents[0]);