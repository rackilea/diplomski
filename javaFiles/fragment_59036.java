class Foo{
  private int property1;
  private int property2;
  ....
  private int property100;

  private void writeObject(ObjectOutputStream out) throws IOException
  {
     out.writeInt(property67);
     out.writeInt(property76);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
  {
    property67 = in.readInt();
    property76 = in.readInt();
  }
}