private Set<Car> car = new HashSet<Car>(0);

@OneToMany(fetch=FetchType.LAZY, mappedBy="persons")
    public Set<Car> getCar() {
        return this.car;
 }
public void setCar(Set<Car> car) {
        this.car = car;
    }