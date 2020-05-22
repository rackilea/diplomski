@Override
public List<E> shallowCopy() {

     LinkedStack<E> newstack = new LinkedStack<E>();
     ArrayList<E> Alist = new ArrayList<E>();
    //Iterate through while we haven't hit the end of the stack
    Node newtest = top;
    while (newtest != null) {
        Alist.add(newtest.data);
        newtest = newtest.next;
    //TODO 85
    }
    for(int i = Alist.size()-1;i>=0;i--) {
        newstack.push(Alist.get(i));
    }
    //System.out.println("FINSHED!");
    return newstack;
}