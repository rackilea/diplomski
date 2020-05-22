public class Sample {
    List<Data> datas = new ArrayList<Data>();

    datas.add(new Data("1", "2" ,"3"));
    datas.add(new Data("4", "5" ,"6"));

    datas.get(0); // should give you the first data
}

class Data {
    Object id,name,desc;
    Data(Object id, Object name, Object desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
}