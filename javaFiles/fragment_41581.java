public class Holder<T>
{
    public T value; // Use a property in real code!
}

public void createArray(Holder<byte[]> holder, int length)
{
    holder.value = new byte[length]; 
    for (int i=0; i < length; i++)
    {
        holder.value[i] = (byte) i;
    }
}