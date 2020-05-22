Iterator<Integer> iter = list.iterator();
while (iter.hasNext()) {
    Integer item = iter.next(); 
    System.out.println(item + " ");
    iter.remove(); // Will throw an UpsupportedOperationException
}