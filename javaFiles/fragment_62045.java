final Object received = ois.readObject();
if (received instanceof FooMessage)
{
  ...
}
else if (received instanceof BarMessage)
{
}