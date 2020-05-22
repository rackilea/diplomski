@Entity
@Table(name = "car_comp")
class Car {
    @Column(name = "car_comp")
    String car_comp;

    @Column(name = "car_type")
    @Convert(converter = CarTypeConverter.class)
    List<String> car_type;

    @Column(name = "car_price")
    String car_price;

    @Column(name = "car_value")
    String car_comp_value;
    //getters and setter below...
}