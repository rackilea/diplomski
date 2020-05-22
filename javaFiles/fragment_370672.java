public enum DogType {
POODLE(2, 20), MASTIFF(40, 45);

private int weight;
private int height;

DogType(int weight, int height) {
    this.weight = weight;
    this.height = height;
}

public int getWeight() {
    return weight;
}

public int getHeight() {
    return height;
}
}