//Switch ints (Works)
int temp = list.get(g);
list.set(g,list.get(h));
list.set(h,temp);
// *** Don't increment here ***

// *** Switch Strings with the ints first ***
String tempStr = list2.get(g);
list2.set(g,list2.get(h));
list2.set(h,tempStr );

// *** Now increment ***
 g++;
 h--;