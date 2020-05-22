public Entry{
 volatile Object value;
 public Entry(Object v){
     value = v;
 }
}

Thread 1
Entry e = new Entry(new Object());

Thread 2
if(e != null)
    Object value =  e.value; // here, according to the JMM, value can be null.  
                             // If value were final it would never be null