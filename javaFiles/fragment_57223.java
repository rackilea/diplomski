public boolean contains(int number) {
     for (int i=0; i<values.length; i++) 
          if (number==values[i]) return true;
     return false;
}

public void add(int number) {
     int[] tmp = new int[value.length+1];
     for (int i=0; i<values.length; i++) tmp[i] = values[i];
     tmp[tmp.length-1] = number;
     values = tmp;
}