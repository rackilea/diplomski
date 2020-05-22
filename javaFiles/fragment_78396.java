class Animals {
    @JsonSerialize(using = MyDogSerializer.class)
    public Dog dog;

    public Animals() {
        this.dog = new Dog();
    }
}