Object received = null;
while(received==null)
{
    received = ois.readObject();
}
System.out.println(received);