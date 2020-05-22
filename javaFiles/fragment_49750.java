Iterator itr = object3.iterator();

while(itr.hasNext()) {
   Myclass element = (Myclass) itr.next();
   if(element.getName().equals(str3) && element.getDepartment().equals(str4))
   {
       itr.remove();
       break;
   }
}