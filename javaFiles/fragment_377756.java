//loop start
     //some code
     arrayList.add(currenttitle+"////.////"+currentartist+" | "+currentalbum+"////.////"+currentlocation);
     //some code
//loop end
Collections.sort(arrayList,String.CASE_INSENSITIVE_ORDER);
for(int i=0;i<arrayList.size();i++) {
    arrayListloc.add(arrayList.get(i).split("////.////")[2]);
}