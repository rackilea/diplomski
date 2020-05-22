private final E[] data;

public Array(int size, E[] data)
{
    this.size=size;
    this.data = Arrays.copyOf(data, size);
}