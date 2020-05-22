public class MyShop {
  private MyShop readShop;

  public MyShop getReadShop() { return readShop; }

  public void loadShop(String fName) {
    try {
       ObjectInput out = new ObjectInputStream(new FileInputStream(filename));
       this.readShop = (MyShop)out.readObject();
       out.close();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
}