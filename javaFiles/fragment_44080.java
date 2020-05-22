public class Airplane {
    private int id;
    private String name;

    private Engine rightEngine;
    private Engine leftEngine;

    public Airplane(String name) {
        this.name = name;
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

    public Engine getRightEngine() {
        return rightEngine;
    }

    public void setRightEngine(Engine rightEngine) {
        this.rightEngine = rightEngine;
    }

    public Engine getLeftEngine() {
        return leftEngine;
    }

    public void setLeftEngine(Engine leftEngine) {
        this.leftEngine = leftEngine;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rightEngline=" + (rightEngine == null ? null : rightEngine.getName()) +
                ", leftEngine=" + (leftEngine == null ? null : leftEngine.getName()) +
                '}';
    }
}