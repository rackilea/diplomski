public abstract class Fictional<A extends Fictional> {
    public ArrayList<A> subclassArray = new ArrayList<A>();
    int i;

    public Fictional(int i) {
        this.i = i;
    }

    public A loadFromFile() //I wouldn't have to override this method
    {
        A subclass = this.build(1); //it's not possible to make new instance of abstract class, but it would be possible with any other subclass
        subclassList.put(subclass);
        return subclass;
    }

    protected abstract A build(int i);
}

class Real extends Fictional
{
    public Real(int i) {
        super(i);
    }

    @Override
    protected Fictional build(int i) {
        return new Real(i);
    }
}