public static void main(String[] args)
{
    List<String> l1 = new ArrayList<>();
    l1.add("v1");
    l1.add("v2");
    Iterator<String> it =  l1.iterator();
    l1.remove(0);
    while(it.hasNext()) {
        System.out.println(it.next());  // --> ConcurrentModificationException
    }
}