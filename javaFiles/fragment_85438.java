87   public class HashSet<E>
88       extends AbstractSet<E>
89       implements Set<E>, Cloneable, java.io.Serializable
90   {
91       static final long serialVersionUID = -5024744406713321676L;
92   
93       private transient HashMap<E,Object> map;
94   
95       // Dummy value to associate with an Object in the backing Map
96       private static final Object PRESENT = new Object();