public Employee(Long id, String name, String city) {
    this.id = id;
    this.name = name;
    this.address = new Address();
    this.address.setCity(city);
}