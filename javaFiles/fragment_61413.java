public <T> T[] toArray(T[] arr)
{       
    T[] result = arr.size == size ? arr : (T[])java.lang.reflect.Array
              .newInstance(arr.getClass().getComponentType(), size);

    for(int i = 0;i<size;i++)
    {
        result[i] = elementData[i];
    }

    return result;
}