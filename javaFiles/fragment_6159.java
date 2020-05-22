public class WrappedProperty implements IProperty {

    private String name;

    private Property prop;

    WrappedProperty (Property prop) {
        this.prop = prop;
    }

    protected void setName(String name) {
        this.name = name;
    }
    public int getWhatever() {
        return prop.getWhatever();
    }
    public int getFoobar() {
        return prop.getFoobar();
    }    
    public String getName() {
        if (this.name == null) {
           return prop.getName():
        } else {
            return this.name; 
        }
    }
}