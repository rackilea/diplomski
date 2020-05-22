public class Engine {

    private int id;
    private String name;
    private byte position;//0=left, 1=right
    private Airplane ownerAirplane;

    /**
     * @param name
     * @param position 0=left, 1=right
     */
    public Engine(String name, byte position) {
        this.name = name;
        this.position = position;
    }

    public Airplane getOwnerAirplane() {
        return ownerAirplane;
    }

    public void setOwnerAirplane(Airplane ownerAirplane) {
        this.ownerAirplane = ownerAirplane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 0=left, 1=right
     */
    public byte getPosition() {
        return position;
    }

    /**
     * @param position 0=left, 1=right
     */
    public void setPosition(byte position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", ownerAirplane=" + (ownerAirplane == null ? null : ownerAirplane.getName()) +
                '}';
    }
}