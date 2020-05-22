public static boolean isPrimitiveArray(Class<?> type, int dimensions) {
        Class<?> componentType = type;
        int count = 0;
        while ((componentType = componentType.getComponentType()) != null) {
            count++;
            if (componentType.isPrimitive() && dimensions == count) {
                return true;
            }
        }

        return false;
    }


  System.out.println(isPrimitiveArray(int[].class,1)); // true
  System.out.println(isPrimitiveArray(int[][].class,2)); // true
  System.out.println(isPrimitiveArray(int[][][].class,2)); // false