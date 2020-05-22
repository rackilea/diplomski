public class Custom implements Serializable{

    private static final long serialVersionUID = 4466821913603037341L;
    private List<Hashtable<String, String>> list;


    public List<Hashtable<String, String>> getList() {
        return list;
    }

    public void setList(List<Hashtable<String, String>> list) {
        this.list = list;
    }
}