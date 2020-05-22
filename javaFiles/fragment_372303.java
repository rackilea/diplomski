public enum EAnimals {
    dogs(1, "white", "big"), // <-- ,
    cats(2, "black", "small");
    private Integer animalId;
    private String color;
    private String size;

    EAnimals(Integer animalId, String color, String size) {
        this.animalId = animalId;
        this.color = color;
        this.size = size;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public String getColor() { // <-- String
        return color;
    }

    public String getSize() { // <-- using an enum in a switch.
        switch (this) {
        case dogs:
            return "small";
        case cats:
            return "big";
        default:
            return "Error";
        }
    }
}