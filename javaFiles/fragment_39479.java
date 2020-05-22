public static boolean isPrimitiveArray(Class<?> type) {
        Class<?> componentType = type;
        while ((componentType = componentType.getComponentType()) != null) {
            if (componentType.isPrimitive()) {
                return true;
            }
        }
        return false;
    }

  System.out.println(isPrimitiveArray(int[].class)); // true
  System.out.println(isPrimitiveArray(int[][].class)); // true
  System.out.println(isPrimitiveArray(int[][][].class)); // true

  System.out.println(isPrimitiveArray(Integer.class)); // false
  System.out.println(isPrimitiveArray(Integer[].class)); // false
  System.out.println(isPrimitiveArray(int.class)); // false