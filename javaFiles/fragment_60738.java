public class Format2Adapter implements Adapter {

    private Long title;
    String subtitle;

    public void fillTemplate(Core c){
        title = c.getB();
    }
}