class Zoo {
    private Animal[] animals;
    private String zooName;
    private int zooSize;

    public String getName() {
        return zooName;
    }

    public Zoo(String name, int capacity) {
        zooSize = 0;
        animals = new Animal[capacity];
        this.zooName = name;
    }
    public void addAnimal(Animal an) {
        animals[zooSize] = an;
        zooSize++;
    }

    public String toString() {
        String tempStr = "In " + zooName + ", we keep these " + zooSize + " animals:\n";
        for(int i=0; i < zooSize; ++i) {
            tempStr += animals[i].getName() + "\n";
        }
        return tempStr;
    }
}

abstract class Animal {
    private Zoo zoo;
    private String name = "";

    public Animal(String name) {
        this.name = "Animal " + name;
    }

    public String getName() {
        return name;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
        this.zoo.addAnimal(this);
    }

    public String belongsWhere() {
        return  name + " belongs to " +
                zoo.getName() + " zoo";
    }
}