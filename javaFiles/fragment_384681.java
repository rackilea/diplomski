public class MyExcelRowObject {

    private String id;
    private String type;
    private String name;
    private String $;

    public MyExcelRowObject(){
        super();
    }

    public MyExcelRowObject(String id, String type, String name, String $) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.$ = $;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String get$() {
        return $;
    }

    public void set$(String $) {
        this.$ = $;
    }

}