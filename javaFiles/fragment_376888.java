final ReentrantLock lock = new ReentrantLock();

final Object[] objects = new Object[10]
public Object setAndReturnPrevious(int index, Object val){
   lock.lock();
      Object prev = get(index);
      set(index,val);
      return prev;
   lock.unlock();
}
public void set(int index, Object val){
    lock.lock();
         objects[index] = val;
    lock.unlock();
}
public Object get(index index){...}