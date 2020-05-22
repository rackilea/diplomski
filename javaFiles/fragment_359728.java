Object[] myObjects = { new Integer(12), new String("foo"),
                new Integer(5), new Boolean(true) };
        Comparator<Object> comparator=new Comparator<Object>() {
            @Override
            public int compare(Object obj1, Object obj2) {
                if(obj1 instanceof String && obj2 instanceof String){
                    return String.valueOf(obj1).compareTo(String.valueOf(obj2));
                }else if(obj1 instanceof Integer && obj2 instanceof Integer){
                    return ((Integer) obj1).compareTo((Integer) obj2);
                }else if(obj1 instanceof Boolean && obj2 instanceof Boolean){
                    return ((Boolean) obj1).compareTo((Boolean) obj2);
                }else if(obj1 instanceof String && obj2 instanceof Integer){
                    return 1;
                }else if(obj1 instanceof Integer && obj2 instanceof String){
                    return -1;
                }else if(obj1 instanceof Boolean){
                    return -1;
                }else if( obj2 instanceof Boolean){
                    return 1;
                }
                return 0;
            }
        }; 
        Arrays.sort(myObjects,comparator);
        for (int i = 0; i < myObjects.length; i++) {
            System.out.print(myObjects[i].toString());
        }