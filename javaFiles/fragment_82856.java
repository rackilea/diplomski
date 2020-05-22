private Object[] toArrayObject(Object[] array){   
    ArrayList<Object> list = new ArrayList<>();
    for(Object obj: array){
      if(obj.getClass().isArray()){
        list.addAll(Arrays.asList(getArray(obj)));
      } else{
        list.add(obj);
      }
    }

    return list.toArray();
  }

  private Object[] getArray(Object val){
    Class<?>[] ARRAY_PRIMITIVE_TYPES = { 
        int[].class, float[].class, double[].class, boolean[].class, 
        byte[].class, short[].class, long[].class, char[].class 
    };

    Class<?> valKlass = val.getClass();
    Object[] outputArray = null;

    for(Class<?> arrKlass : ARRAY_PRIMITIVE_TYPES){
      if(valKlass.isAssignableFrom(arrKlass)){
        int arrlength = Array.getLength(val);
        outputArray = new Object[arrlength];
        for(int i = 0; i < arrlength; ++i){
          outputArray[i] = Array.get(val, i);
        }
        break;
      }
    }
    if(outputArray == null) // not primitive type array
        outputArray = (Object[])val;

    return outputArray;
  }