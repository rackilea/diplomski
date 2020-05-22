public class LinkedList<N extends Node<E>, 
                        E extends Comparable<E>> 
  implements Comparable<LinkedList<N, E>>{
  private N head;
  private N tail;
  private int size;
  ...