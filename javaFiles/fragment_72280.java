public X get(int index) throws ArrayIndexOutOfBoundsException{

    if (index < 0 || index >= size)
        throw new ArrayIndexOutOfBoundsException();

    return arr[index];
}