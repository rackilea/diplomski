private class DLLNode<E>
{
    //data
    protected E data;                       //protected so it is visible inside the DLList class
    protected DLLNode<E> next;    //(so I won't need .getData, .setData...)
    protected DLLNode<E> prev;
    //constructor(s)
    ...