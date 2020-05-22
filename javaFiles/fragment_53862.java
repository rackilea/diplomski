public class Model {

    private String id;

    private String name;

//Use constructor 
    public Model(String id, String name) { 

        this.id = id;

        this.name = name;

    }


    public String getId() {

        return id;

    }


    public void setId(String id) {

        this.id = id;

    }


    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }

}


// Now make your Map data Structure center code hereustom .

Hashmap<String,Model> Map = new Hashmap();

// Create a object of your custom Model datastructure and add data.
Model model = new Model("145","Jason");
Map.put("1st",model);