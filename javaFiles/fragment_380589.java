public class Person extends AbstractEntity {

    @OneToMany(mappedBy = "person", targetEntity = CarPictureRef.class)
    private List<CarPictureRef> picturesOfCars;

    @OneToMany(mappedBy = "person", targetEntity = HolidayPictureRef.class)
    private List< HolidayPictureRef> picturesOfHolidays;

    ...

}