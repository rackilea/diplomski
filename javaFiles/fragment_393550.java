LinkedList<String> list1 = new LinkedList<String>();

// [...] Populate the list accordingly here

for(int i=1; i < list1.count(); i++){
    if (list1.get(i).startsWith("\"")) {
        list1.remove(i);
    }
}