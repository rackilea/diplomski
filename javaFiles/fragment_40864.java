int x=1;
while(x <= 10){
   l1 = new ArrayList<>(l1);//create a new list object with values of the old one
   l1.add(x);
   l2.add(l1);
   x++;
}