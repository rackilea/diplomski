ArrayList<String> ar = new ArrayList<String>();
ar.add("a");
ar.add("b");
ar.add("c");
ar.add("a");
ar.add("e");
Iterator<String> it = ar.iterator();
while (it.hasNext()) {
    String st = it.next();
    System.out.println("st="+st);
    if (st.equals("a")) {
        it.remove();
    }
}