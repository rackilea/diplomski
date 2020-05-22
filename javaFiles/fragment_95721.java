@Override
public String toString(){
   StringBuilder sb = new StringBuilder();
   sb.append("[");
   Node<T> aux = this.head;
   boolean isFirst = true;
   while(aux != null){
       if(!isFirst){
          sb.append(",");
       }
       isFirst = false;
       sb.append(aux.data.toString());
       aux=aux.next;
   }
  return sb.append("]").toString();

}