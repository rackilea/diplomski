public E set(int index, E element) {
   ...
   E oldValue = elementData(index);

public E remove(int index) {
   ...
   E oldValue = elementData(index);

public E set(int index, E e) {
   ...
   E oldValue = ArrayList.this.elementData(offset + index);

public E get(int index) {
   ...
   return ArrayList.this.elementData(offset + index);