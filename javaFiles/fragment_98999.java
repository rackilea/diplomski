class Sensor {

    private int id;
    private String name;
    private String comments;

    public Sensor(int id, String name, String comments) {
        this.id = id;
        this.name = name;       
        this.comments = comments;
    }

    @Override
    public String toString() {
        //You can change how to the string is built in order to achieve your desired output.
        return "id: "+ID+"; name: "+name+"; comments: "+ comment;
    }

}