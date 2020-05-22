...
currentPath=new Stack();

onOpenTag(String tagName){
   this.currentPath.push("tagName");

   if ("Item".equals(tagName)){
      cache.store(convertToPathString(currentPath));
   }
}

onCloseTag(String tagName){
   this.currentPath.pop();
}