public class PropertiesAdapter{
    private Properties props;

    public PropertiesAdapter(){
        this.props = new Properties();
    }

    public PropertiesAdapter(Properties props){
        this.props = props;
    }

    public Object set(String name, String value){
        return this.props.setProperty(name, value);
    }

    public String get(String name){
        return this.props.getProperty(name);
    }
}