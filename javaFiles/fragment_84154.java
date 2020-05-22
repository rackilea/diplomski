public class Menu{
    private final int LIMIT = 20;
    private String[] option;
    private int position;

    public Menu()
    {
        option = new String[LIMIT];
        position = 0;
    }

    public void addTo(String item)
    {
        if(position == LIMIT)
        {
            // We do not want a IndexOutOfBoundsException here
            return;
        }
        option[position++] = item;
    }

    public void printList(){
        for(int i = 0; i< LIMIT; i++)
        {
            System.out.println( i + ": " + option[i] );
        }
    }

    public static void main(String[] args)
    {
        Menu m = new Menu();
        m.addTo("book");
        m.addTo("cup");
        m.addTo("test");

        m.printList();
    }

}