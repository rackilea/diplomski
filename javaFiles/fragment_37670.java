ArrayList<DataCache> cacheOf = new ArrayList<DataCache>(); //initialize here
System.out.println("Size of ContentOf"+contentOf.size());  //This will be zero.
for (int i=0;i<contentOf.size();i++) {
      //..your code here...
    if (cache != null){
       if(i<=cache.size())
         cacheOf.add(cache.get(i));
     }
}