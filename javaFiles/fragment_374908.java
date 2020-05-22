while (it.hasNext()) {
       elementCount = elementCount+1;
       if(first)
       {
           double[] doubleArray = (inst.decode(it.next().toString()));
           lat = Double.toString(doubleArray[0]);
           longi = Double.toString(doubleArray[1]);
           first = false;
       }
  }