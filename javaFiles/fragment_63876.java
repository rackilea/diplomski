public class MonitorComponent{

    String s;
    Date d;
    ...

    public MonitorComponent clone(){
        MonitorComponent m = new MonitorComponent();
        m.s = this.s.clone();
        m.d = this.d.clone();
        ...
        return m;
    }
}