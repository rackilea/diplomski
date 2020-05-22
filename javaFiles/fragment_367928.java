Iterator<String> it = arrayList.iterator();
while (it.hasNext() ) {
   String value = it.next();
   if (value.startsWith("String1-") ) {
     it.remove();
   }
}