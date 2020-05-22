public class Gen <E extends Item> {

  private Object[] items = new Object[5];
  private int itemCounter = 0;

    public void add(E neu) {

        if(itemCounter < items.length){
          this.items[itemCounter] = neu; 
          itemCounter +=1;
        }
    }

    public int length()
    {
        return itemCounter;
    }

   // testing the class
    public static void main(String[] args)
    {
        Item t0 = new Item();
        Item t1 = new Item();
        Item t2 = new Item();
        Item t3 = new Item();
        Item t4 = new Item();
        Item t5 = new Item();

        Gen<Item> g = new Gen<Item>();

        g.add(t0);
        g.add(t1);
        g.add(t2);
        g.add(t3);
        g.add(t4);
        g.add(t5); // ignored

        System.out.println(g.length());

    }
}

  class Item {}