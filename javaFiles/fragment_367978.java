iter1 = list1.iterator()
iter2 = list2.iterator()
//before these commands make sure the lists are not empty:
curr1 = iter1.next(); 
curr2 = iter2.next();
List result = new LinkedList();
while curr1 != null && curr2 != null {
   if curr1 < curr2 { 
          result.add(curr1);
          curr1 = list1.next();
   } else { 
          result.add(curr2);
          curr2 = list2.next();
   }
}
while (curr1 != null) {
   result.add(curr1);
   curr1 = curr1.next();
}
while (curr2 != null) {
   result.add(curr2);
   curr2 = curr1.next();
}