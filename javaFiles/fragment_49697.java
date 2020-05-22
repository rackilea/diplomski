public void add(Character a, Character b){

        if (adj.containsKey(a)){

           //get a reference to the existing linked list
           LinkedList<Character> l = adj.get(a);

           //add to the existing LinkedList
           //You need to do a null check here to make sure (l != null)
           l.add(b)
        }else{

           //create a new LinkedList and add to it.
           LinkedList<Character> l = new LinkedList<Character>();
           l.add(b);
           adj.put(a, l);
        }

    }
}