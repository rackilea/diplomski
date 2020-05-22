private <T> T[] remove(T string, T[] charSequences)
    {
        ArrayList<T> newArray = new ArrayList<T>();
        int foundPlace = -1;
        T[] v = charSequences;
        for (int i = 0; i < v.length; i++) {
            if (foundPlace != -1 && v[i].equals(string))
                foundPlace = i;
            else
                newArray.add(v[i]);
        }
        @SuppressWarnings("unchecked")
        T[] ret = (T[]) Array.newInstance(v.getClass().getComponentType(), newArray.size());
        return newArray.toArray(ret);
    }