Queue<String> qe = new LinkedList<String>();

qe.add("b");
qe.add("a");
qe.add("c");

//Traverse queue
Iterator it = qe.iterator();

System.out.println("Initial Size of Queue :" + qe.size());

while(it.hasNext())
{
   String iteratorValue = (String) it.next();
   System.out.println("Queue Next Value :" + iteratorValue);
}