public class Handler
{
    LinkedList<IUpdateable> modulCollection = new LinkedList<IUpdateable>();

    void add<T>(Modul<T> m) // It is generic now
    {
        this.dataCollection.add(m);
    }

    void update(){
        foreach (IUpdateable d in this.modulCollection){
              d.update();
        }
    }
}