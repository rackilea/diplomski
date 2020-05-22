private static boolean typesMatch(Class<?>[] one, Object[] two)
    {
        if(one.length != two.length) {
            return false;
        }

        for (int i = 0; (i < one.length)&&(i < two.length); i++){
            if ((one[i].isPrimitive() && two[i].getClass().getSimpleName().equalsIgnoreCase(one[i].getName())) ||
                    (two[i].getClass().isPrimitive() && one[i].getSimpleName().equalsIgnoreCase(two[i].getClass().getName()))) {
                return true;
            }
            if(!one[i].equals(two[i].getClass())) {
                return false;
            }
        }

        return true;
    }