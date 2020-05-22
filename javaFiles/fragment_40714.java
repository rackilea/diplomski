
      public String toString() {
          Iterator<E> i = iterator();
              return "[]";
         StringBuilder sb = new StringBuilder();
          sb.append('[');
          for (;;) {
               E e = i.next();
               sb.append(e == this ? "(this Collection)" : e);
               if (! i.hasNext())
                   return sb.append(']').toString();
           }