import java.beans.PropertyChangeSupport ;

public class Person()
{
    private int id;
    private String name;

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public int getId()
    {
       return this.id;
    }

    public void setId(int id) 
    {
       int oldId = this.id ;
       this.id = id ;
       pcs.firePropertyChange("id", oldId, id);
    }

    public String getName()
    {
       return this.name;
    }

    public void setName(String name) 
    {
        String oldName = this.name ;
        this.name = name ;
        pcs.firePropertyChange("name", oldName, name);
    }
}