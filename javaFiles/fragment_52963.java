LinkedList<Integer>[] vertex = new LinkedList[5];
int i = 0, m = 6;
while(i!=m){
  int temp = sc.nextInt();
  int temp2 = sc.nextInt();

  // Make sure the list is initialized before adding to it
  if (vertex[temp] == null) {
     vertex[temp] = new LinkedList<Integer>();
  }

  vertex[temp].add(temp2);
  i++;
}